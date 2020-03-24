package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.PageResult;
import xyz.yishe.pigeon.core.BrandService;
import xyz.yishe.pigeon.server.request.BrandQueryRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

import static xyz.yishe.pigeon.config.SpringSessionConfiguration.TOKEN_HEADER;

/**
 * 品牌
 *
 * @author aotianpan
 * @date 2020-03-22 8:42 上午
 */
@RestController
@RequestMapping("brand")
@Api(tags = "品牌中心")
@RequiredArgsConstructor
public class BrandEndpoint extends BaseEndpoint {
    private final BrandService brandService;

    @ApiOperation(value = "查询品牌详情")
    @PostMapping("detail/{brandId}")
    public CustomizedResponseEntity<BrandResponse> detail(
            @RequestHeader(TOKEN_HEADER) String token, @PathVariable String brandId) {
        return CustomizedResponseEntity.ok(brandService.detail(brandId));
    }

    @ApiOperation(value = "分页查询品牌信息")
    @PostMapping("/page/query")
    public CustomizedResponseEntity<PageResult<BrandResponse>> pageQuery(
            @RequestHeader(TOKEN_HEADER) String token, @RequestBody PageQuery<BrandQueryRequest> pageQuery) {
        return CustomizedResponseEntity.ok(brandService.pageQuery(pageQuery));
    }
}
