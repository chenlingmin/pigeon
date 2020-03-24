package xyz.yishe.pigeon.dao.mybatis.mapper;

import xyz.yishe.pigeon.dao.mybatis.bo.BrandQueryBo;
import xyz.yishe.pigeon.dao.mybatis.vo.BrandVo;
import xyz.yishe.pigeon.server.response.BrandResponse;

import java.util.List;

/**
 * @author aotianpan
 * @date 2020-03-21 5:54 下午
 */
public interface BrandMapper {
    List<BrandVo> listBrand(BrandQueryBo brandQueryBo);
}
