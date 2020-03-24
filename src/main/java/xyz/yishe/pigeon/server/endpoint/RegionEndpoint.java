package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.core.RegionService;
import xyz.yishe.pigeon.server.request.RegionRequest;
import xyz.yishe.pigeon.server.response.RegionResponse;

import java.util.List;

import static xyz.yishe.pigeon.config.SpringSessionConfiguration.TOKEN_HEADER;

/**
 * 区域
 *
 * @author aotianpan
 * @date 2020-03-22 8:42 上午
 */
@Slf4j
@RestController
@RequestMapping("region")
@Api(tags = "行政区域中心")
@RequiredArgsConstructor
public class RegionEndpoint extends BaseEndpoint {
    private final RegionService regionService;

    @ApiOperation(value = "查询区域列表")
    @PostMapping("query")
    public CustomizedResponseEntity<List<RegionResponse>> query(
            @RequestHeader(TOKEN_HEADER) String token, @RequestBody RegionRequest request) {
        return CustomizedResponseEntity.ok(regionService.list(request));
    }

    @ApiOperation(value = "查询省市区树", notes = "查询省市区树", httpMethod = "POST")
    @PostMapping(value = "tree")
    public CustomizedResponseEntity<List<RegionResponse>> tree(@RequestHeader(TOKEN_HEADER) String token) {
        return CustomizedResponseEntity.ok(regionService.tree());
    }
}
