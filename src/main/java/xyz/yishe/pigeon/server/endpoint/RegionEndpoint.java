package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.core.RegionService;
import xyz.yishe.pigeon.server.request.RegionRequest;
import xyz.yishe.pigeon.server.response.RegionResponse;

import java.util.List;

/**
 * 区域
 *
 * @author aotianpan
 * @date 2020-03-22 8:42 上午
 */
@RestController
@RequestMapping("/region")
@Api(value = "/region", tags = "品牌")
@RequiredArgsConstructor
public class RegionEndpoint extends BaseEndpoint {
    private final RegionService regionService;

    @ApiOperation(value = "查询区域列表")
    @PostMapping("/list")
    public CustomizedResponseEntity<List<RegionResponse>> query(
            @RequestBody RegionRequest request
    ) {
        return CustomizedResponseEntity.ok(regionService.list(request));
    }

    @ApiOperation(value = "查询省市区树", notes = "查询省市区树", httpMethod = "POST")
    @PostMapping(value = "/query-tree")
    public CustomizedResponseEntity<List<RegionResponse>> queryTree() {
        return CustomizedResponseEntity.ok(regionService.queryTree());
    }
}
