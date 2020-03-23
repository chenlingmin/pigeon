package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.RegionEntity;

import java.util.List;

/**
 * 区域
 *
 * @author aotianpan
 * @date 2020-03-21 4:54 下午
 */
@Repository
public interface RegionRepository extends CrudRepository<RegionEntity, String> {
    List<RegionEntity> findByParentNo(Integer parentNo);
}
