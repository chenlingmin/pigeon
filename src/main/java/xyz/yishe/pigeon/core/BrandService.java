package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.PageResult;
import xyz.yishe.pigeon.server.request.BrandQueryRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

/**
 * 品牌
 * @author aotianpan
 * @date 2020-03-21 5:21 下午
 */
public interface BrandService {
    /**
     * 分页查询品牌列表
     * @param pageQuery
     * @return
     */
    PageResult<BrandResponse> pageQuery(PageQuery<BrandQueryRequest> pageQuery);

    /**
     * 查询品牌详情
     * @param request
     * @return
     */
    BrandResponse query(BrandQueryRequest request);
}
