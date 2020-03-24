package xyz.yishe.pigeon.core.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.util.BeanCopyUtil;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.core.MenuService;
import xyz.yishe.pigeon.dao.jpa.entity.MenuEntity;
import xyz.yishe.pigeon.dao.jpa.repository.MenuRepository;
import xyz.yishe.pigeon.dao.mybatis.bo.MenuQueryBo;
import xyz.yishe.pigeon.dao.mybatis.mapper.MenuMapper;
import xyz.yishe.pigeon.dao.mybatis.vo.MenuQueryVo;
import xyz.yishe.pigeon.server.request.MenuCreateRequest;
import xyz.yishe.pigeon.server.request.MenuQueryRequest;
import xyz.yishe.pigeon.server.request.MenuUpdateRequest;
import xyz.yishe.pigeon.server.response.MenuQueryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 品牌业务类
 *
 * @author aotianpan
 * @date 2020-03-21 5:30 下午
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    public static final int TIER_1 = 1; // 菜单层级
    public static final int TIER_2 = 2;
    public static final int TIER_3 = 3;
    public static final int TOP_PID = 0; // 顶级PID

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;


    @Override
    public List<MenuQueryResponse> query(MenuQueryRequest menuQueryRequest) {
        List<MenuQueryResponse> menuQueryResponse = new ArrayList<>();

        List<MenuQueryVo> menuQueryVo = menuMapper.query(menuQueryRequest.convert(MenuQueryBo::new));
        if (CommonUtils.isNotEmpty(menuQueryVo)) {
            menuQueryResponse = menuQueryVo.stream()
                    .map(mqv -> mqv.convert(MenuQueryResponse::new))
                    .collect(Collectors.toList());
        }

        return menuQueryResponse;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void create(MenuCreateRequest menuCreateRequest) {
        String route = menuCreateRequest.getRoute(); // 前端路由
        Integer pid = menuCreateRequest.getPid(); // 父级编号

        // 父节点处理
        if (CommonUtils.isEmpty(pid)) {
            pid = TOP_PID;
        }

        // 校验
        checkMenu(route, pid);

        // 构建菜单实体
        MenuEntity menuEntity = menuCreateRequest.convert(MenuEntity::new);
        menuRepository.save(menuEntity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void update(MenuUpdateRequest menuUpdateRequest) {
        Integer menuId = menuUpdateRequest.getId(); // 菜单编号
        String route = menuUpdateRequest.getRoute(); // 前端路由
        Integer pid = menuUpdateRequest.getPid(); // 父级编号

        // 父节点处理
        if (CommonUtils.isEmpty(pid)) {
            pid = TOP_PID;
        }

        // 校验
        checkMenu(route, pid);

        // 更新
        MenuEntity menuEntity = this.load(menuId);
        menuEntity = BeanCopyUtil.copyIgnoreNullValue(menuUpdateRequest, menuEntity);
        menuRepository.save(menuEntity);
    }

    /**
     * 菜单校验
     *
     * @param route 前端路由
     * @param pid   父节点
     */
    private void checkMenu(String route, Integer pid) {
        if (menuRepository.findByRoute(route).isPresent()) {
            throw new BizException("创建菜单失败，路由已经存在！");
        }

        // 验证pid
        MenuEntity parentMenu = this.get(pid);
        if (CommonUtils.isEmpty(parentMenu)) {
            throw new BizException("创建菜单失败，父级菜单不存在！");
        }
    }

    @Override
    public MenuEntity get(Integer menuId) {
        return menuRepository.findById(menuId).orElse(null);
    }

    @Override
    public MenuEntity load(Integer menuId) {
        return menuRepository.findById(menuId).orElseThrow(() -> new BizException("菜单不存在！"));
    }
}
