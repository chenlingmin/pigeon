package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yishe.pigeon.dao.jpa.entity.RegionEntity;

/**
 * 区域
 * @author aotianpan
 * @date 2020-03-21 4:54 下午
 */
public interface RegionRepository extends CrudRepository<String, RegionEntity> {
}
