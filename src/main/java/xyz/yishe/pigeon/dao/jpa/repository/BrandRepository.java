package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.BrandEntity;

import java.util.List;

/**
 * 品牌
 * @author aotianpan
 * @date 2020-03-21 10:43 上午
 */
@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, String> {

    List<BrandEntity> findByNameAndParentId(String name, String parentId);

    List<BrandEntity> findByNameAndParentIdIsNull(String name);
}
