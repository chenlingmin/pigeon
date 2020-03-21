package xyz.yishe.pigeon.dao.mybatis.mapper;

import xyz.yishe.pigeon.dao.mybatis.bo.UserQueryBo;
import xyz.yishe.pigeon.dao.mybatis.vo.UserQueryVo;

import java.util.List;

/**
 * 用户信息
 *
 * @author owen 2019-12-24
 */
public interface UserMapper {
    /**
     * 查询用户列表
     *
     * @param userQueryBo
     * @return
     */
    List<UserQueryVo> listUser(UserQueryBo userQueryBo);
}
