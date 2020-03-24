package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.UserRoleEntity;

import java.util.List;


/**
 * @author owen
 * @date 2019-12-21 16:48
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Integer> {
    /**
     * 删除用户角色
     *
     * @param userId 用户编号
     */
    int deleteByUserId(String userId);

    /**
     * 查询用户角色（排除禁用的角色）
     *
     * @param userId 用户编号
     * @return
     */
    @Query("select ur " +
            "from UserRoleEntity ur,RoleEntity r " +
            "where ur.roleId = r.id and r.state = 1 and ur.userId = ?1")
    List<UserRoleEntity> listUserRole(String userId);
}