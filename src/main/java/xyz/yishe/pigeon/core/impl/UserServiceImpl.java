package xyz.yishe.pigeon.core.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.model.enums.UserStateEnum;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.core.UserService;
import xyz.yishe.pigeon.dao.jpa.entity.UserEntity;
import xyz.yishe.pigeon.dao.jpa.repository.UserRepository;
import xyz.yishe.pigeon.server.request.UserCreateRequest;
import xyz.yishe.pigeon.server.request.UserLoginRequest;
import xyz.yishe.pigeon.server.response.UserCreateResponse;

import java.util.List;

/**
 * @author owen
 * @date 2020-03-21 10:16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public UserCreateResponse create(UserCreateRequest userCreateRequest) {
        String shopId = userCreateRequest.getShopId();
        String phone = userCreateRequest.getPhone();
        String contact = userCreateRequest.getContact();

        // 重复性校验
        UserEntity userEntity = this.getByPhone(phone);
        if (CommonUtils.isNotEmpty(userEntity)) {
            throw new BizException("创建客户失败，手机号码重复!");
        }

        // 构建实体
        userEntity = UserEntity.builder()
                .shopId(shopId)
                .phone(phone)
                .nickname(contact)
                .state(UserStateEnum.OK.getValue())
                .build();
        userEntity = this.initPassword(userEntity); // 初始化密码
        userEntity = userRepository.save(userEntity);
        String userId = userEntity.getId();

        return UserCreateResponse.builder().userId(userId).build();
    }

    @Override
    public UserEntity login(UserLoginRequest userLoginRequest) {
        String phone = userLoginRequest.getPhone();
        String captcha = userLoginRequest.getCaptch(); // 验证码

        // 查询用户详情
        UserEntity userEntity = this.getByPhone(phone);
        if (CommonUtils.isEmpty(userEntity)) {
            throw new BizException("用户不存在！");
        }

        // 密码校验
        String salt = userEntity.getSalt();
        if (!password(captcha, salt).equals(userEntity.getPassword())) {
            throw new BizException("用户名或密码错误！");
        }

        // 用户状态校验
        UserStateEnum stateEnum = UserStateEnum.fromValue(userEntity.getState());
        if (UserStateEnum.BAN.equals(stateEnum)) {
            throw new BizException("用户状态异常！");
        }

        return userEntity;
    }

    @Override
    public void pass(String userId) {
        UserEntity userEntity = this.load(userId);
        userEntity.setState(UserStateEnum.OK.getValue()); // 启用
        userRepository.save(userEntity);
    }

    @Override
    public void ban(String userId) {
        UserEntity userEntity = this.load(userId);
        userEntity.setState(UserStateEnum.BAN.getValue()); // 禁用
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity get(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public UserEntity load(String userId) throws BizException {
        return userRepository.findById(userId).orElseThrow(() -> new BizException("用户不存在！用户编号: " + userId));
    }

    @Override
    public void shopBan(String shopId) {
        List<UserEntity> userEntityList = userRepository.findByShopId(shopId);
        if (CommonUtils.isEmpty(userEntityList)) {
            return;
        }

        // 禁用用户
        userEntityList.forEach(user -> ban(user.getId()));
    }

    /**
     * 查询用户详情
     *
     * @param phone
     * @return
     */
    private UserEntity getByPhone(String phone) {
        return userRepository.findByPhone(phone).orElse(null);
    }

    /**
     * 初始化用户密码
     *
     * @param userEntity
     * @return
     */
    private UserEntity initPassword(UserEntity userEntity) {
        String phone = userEntity.getPhone();
        String salt = DigestUtils.md5Hex(RandomStringUtils.random(8)); // 盐值
        String reverse = new StringBuffer(phone).reverse().toString(); // 密码反转
        String passwordClear = reverse.concat(reverse.substring(0, 6)); //  明文
        String passwordCipher = this.password(passwordClear, salt);
        userEntity.setSalt(salt);
        userEntity.setPassword(passwordCipher);

        return userEntity;
    }

    /**
     * 生成密码
     *
     * @param clear 明文
     * @param salt  盐值
     * @return
     */
    private String password(String clear, String salt) {
        return DigestUtils.md5Hex(salt.concat(clear).concat(salt));
    }
}
