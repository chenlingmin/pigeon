package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.ConfigEntity;

import java.util.Optional;

/**
 * @author owen
 * @date 2019-12-21 16:48
 */
@Repository
public interface ConfigRepository extends CrudRepository<ConfigEntity, Integer> {
    Optional<ConfigEntity> findByKeyword(String keyword);
    Optional<ConfigEntity> findByKeywordAndType(String keyword, Integer type);
}
