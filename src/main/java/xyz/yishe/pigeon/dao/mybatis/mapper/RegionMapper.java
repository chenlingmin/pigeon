package xyz.yishe.pigeon.dao.mybatis.mapper;

import xyz.yishe.pigeon.dao.mybatis.bo.RegionQueryBo;
import xyz.yishe.pigeon.dao.mybatis.vo.RegionVo;

import java.util.List;

/**
 * 区域
 * @author aotianpan
 * @date 2020-03-21 5:54 下午
 */
public interface RegionMapper {

    List<RegionVo> listRegion(RegionQueryBo regionQueryBo);
}
