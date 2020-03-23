package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;


/**
 * @author owen
 * @date 2019-12-21 16:48
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
    /**
     * 查询用户详情
     *
     * @param phone 手机号
     * @return
     */
    Optional<UserEntity> findByPhone(String phone);

    /**
     * 查询用户列表
     *
     * @param shopId 店铺编号
     * @return
     */
    List<UserEntity> findByShopId(String shopId);
}