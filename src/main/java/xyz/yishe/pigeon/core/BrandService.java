package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.PageResult;
import xyz.yishe.pigeon.server.request.BrandQueryRequest;
import xyz.yishe.pigeon.server.request.BrandRequest;
import xyz.yishe.pigeon.server.request.UpdateBrandRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

/**
 * 品牌
 *
 * @author aotianpan
 * @date 2020-03-21 5:21 下午
 */
public interface BrandService {
    /**
     * 分页查询品牌列表
     *
     * @param pageQuery
     * @return
     */
    PageResult<BrandResponse> pageQuery(PageQuery<BrandQueryRequest> pageQuery);

    /**
     * 查询品牌详情
     *
     * @param brandId
     * @return
     */
    BrandResponse detail(String brandId);

    /**
     * 新增品牌
     *
     * @param brandRequest 品牌
     */
    BrandResponse add(BrandRequest brandRequest);

    /**
     * 修改品牌
     *
     * @param brandRequest 品牌信息
     */
    BrandResponse update(UpdateBrandRequest brandRequest);

    /**
     * 删除品牌
     *
     * @param brandRequest 品牌信息
     */
    void delete(BrandRequest brandRequest);
}
