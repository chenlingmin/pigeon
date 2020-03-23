package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.PageResult;
import xyz.yishe.pigeon.core.BrandService;
import xyz.yishe.pigeon.server.request.BrandQueryRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

/**
 * 品牌
 * @author aotianpan
 * @date 2020-03-22 8:42 上午
 */
@RestController
@RequestMapping("/brand")
@Api(value = "/brand", tags = "品牌")
@RequiredArgsConstructor
public class BrandEndpoint extends BaseEndpoint {
    private final BrandService brandService;

    @ApiOperation(value = "查询品牌详情")
    @PostMapping("/query")
    public CustomizedResponseEntity<BrandResponse> query(
            @RequestBody BrandQueryRequest request
            ) {
        return CustomizedResponseEntity.ok(brandService.query(request));
    }

    @ApiOperation(value = "分页查询品牌信息")
    @PostMapping("/page/query")
    public CustomizedResponseEntity<PageResult<BrandResponse>> pageQuery(
            @RequestBody PageQuery<BrandQueryRequest> pageQuery
    ) {
        return CustomizedResponseEntity.ok(brandService.pageQuery(pageQuery));
    }
}
