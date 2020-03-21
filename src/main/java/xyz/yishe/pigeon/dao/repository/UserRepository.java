package xyz.yishe.pigeon.dao.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yishe.pigeon.dao.entity.UserEntity;

import java.util.Optional;

/**
 * @author owen
 * @date 2019-12-21 16:48
 */
public interface UserRepository extends CrudRepository<UserEntity, String> {
    Optional<UserEntity> findByOpenId(String openId);
    Optional<UserEntity> findByPhone(String phone);
}