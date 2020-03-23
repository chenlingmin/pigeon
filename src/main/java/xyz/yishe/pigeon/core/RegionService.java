package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.server.request.RegionRequest;
import xyz.yishe.pigeon.server.response.RegionResponse;

import java.util.List;

/**
 * 区域
 * @author aotianpan
 * @date 2020-03-22 6:06 下午
 */
public interface RegionService {
    /**
     * 查询区域列表
     * @param regionRequest
     * @return
     */
    List<RegionResponse> list(RegionRequest regionRequest);

    /**
     * 查询省市区树
     * @return
     */
    List<RegionResponse> queryTree();
}
