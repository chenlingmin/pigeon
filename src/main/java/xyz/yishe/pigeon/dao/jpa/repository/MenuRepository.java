package xyz.yishe.pigeon.dao.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yishe.pigeon.dao.jpa.entity.MenuEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends CrudRepository<MenuEntity, Integer> {
    Optional<MenuEntity> findByRoute(String route);
    Optional<MenuEntity> findByUrl(String url);
    List<MenuEntity> findByPid(Integer pid);
}