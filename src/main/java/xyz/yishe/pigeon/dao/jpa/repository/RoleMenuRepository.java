package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.RoleMenuEntity;

@Repository
public interface RoleMenuRepository extends CrudRepository<RoleMenuEntity, Integer> {
    int deleteByRoleId(Integer roleId);
}