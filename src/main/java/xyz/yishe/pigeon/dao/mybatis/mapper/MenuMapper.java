package xyz.yishe.pigeon.dao.mybatis.mapper;

import xyz.yishe.pigeon.dao.mybatis.bo.MenuQueryBo;
import xyz.yishe.pigeon.dao.mybatis.vo.MenuQueryVo;

import java.util.List;

/**
 * @author aotianpan
 * @date 2020-03-21 5:54 下午
 */
public interface MenuMapper {
    List<MenuQueryVo> query(MenuQueryBo menuQueryBo);
}
