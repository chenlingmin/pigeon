package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.ShopEntity;

import java.util.Optional;


/**
 * @author owen
 * @date 2019-12-21 16:48
 */
@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, String> {
    Optional<ShopEntity> findByPhone(String phone);
}