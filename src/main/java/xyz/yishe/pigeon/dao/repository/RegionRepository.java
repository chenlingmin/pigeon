package xyz.yishe.pigeon.dao.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yishe.pigeon.dao.entity.RegionEntity;

/**
 * 区域
 * @author aotianpan
 * @date 2020-03-21 4:54 下午
 */
public interface RegionRepository extends CrudRepository<String, RegionEntity> {
}
