package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.BrandEntity;

@Repository
public interface BrandRepository  extends CrudRepository<BrandEntity, String> {
}