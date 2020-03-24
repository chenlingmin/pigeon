package xyz.yishe.pigeon.core.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.model.enums.RoleStateEnum;
import xyz.yishe.pigeon.core.RoleService;
import xyz.yishe.pigeon.dao.jpa.entity.RoleEntity;
import xyz.yishe.pigeon.dao.jpa.entity.RoleMenuEntity;
import xyz.yishe.pigeon.dao.jpa.repository.RoleMenuRepository;
import xyz.yishe.pigeon.dao.jpa.repository.RoleRepository;
import xyz.yishe.pigeon.server.request.RoleCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色业务类
 *
 * @author owen
 * @date 2020-03-21 5:30 下午
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMenuRepository roleMenuRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void create(RoleCreateRequest roleCreateRequest) {
        String roleName = roleCreateRequest.getRoleName();

        // 重复性校验
        if (roleRepository.findByRoleName(roleName).isPresent()) {
            throw new BizException("创建角色失败，角色重复！");
        }

        RoleEntity roleEntity = roleCreateRequest.convert(RoleEntity::new);
        roleEntity.setState(RoleStateEnum.OK.getValue());
        roleRepository.save(roleEntity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void pass(Integer roleId) {
        RoleEntity roleEntity = this.load(roleId);
        roleEntity.setState(RoleStateEnum.OK.getValue());
        roleRepository.save(roleEntity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void ban(Integer roleId) {
        RoleEntity roleEntity = this.load(roleId);
        roleEntity.setState(RoleStateEnum.BAN.getValue());
        roleRepository.save(roleEntity);
    }

    /**
     * 查询角色详情
     *
     * @param roleId
     * @return
     * @throws BizException
     */
    private RoleEntity load(Integer roleId) throws BizException {
        return roleRepository.findById(roleId).orElseThrow(() -> new BizException("角色不存在！"));
    }

    @Override
    public void deployRoleMenu(Integer roleId, List<Integer> menuIdList) {
        this.load(roleId);

        // 移除
        int i = roleMenuRepository.deleteByRoleId(roleId);
        log.info("删除 {} 条角色菜单配置项，角色编号：{}", i, roleId);

        // 构建角色菜单配置项
        roleMenuRepository.saveAll(
                menuIdList.stream()
                        .map(menu -> RoleMenuEntity.builder()
                                .roleId(roleId).menuId(menu).build())
                        .collect(Collectors.toList())
        );
    }
}
