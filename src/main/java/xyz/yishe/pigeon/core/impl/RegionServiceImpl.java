package xyz.yishe.pigeon.core.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.core.RegionService;
import xyz.yishe.pigeon.dao.jpa.entity.RegionEntity;
import xyz.yishe.pigeon.dao.jpa.repository.RegionRepository;
import xyz.yishe.pigeon.dao.mybatis.bo.RegionQueryBo;
import xyz.yishe.pigeon.dao.mybatis.mapper.RegionMapper;
import xyz.yishe.pigeon.dao.mybatis.vo.RegionVo;
import xyz.yishe.pigeon.server.request.RegionRequest;
import xyz.yishe.pigeon.server.response.RegionResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aotianpan
 * @date 2020-03-22 6:07 下午
 */
@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private static final int NO_PARENT_ID = 0; // 无父级id
    private static final int PROVINCE_LEVEL = 0; // 省级
    private static final int CITY_LEVEL = 1; // 市级
    private static final int DISTRICT_LEVEL = 2; // 区级
    private final RegionMapper regionMapper;
    private final RegionRepository regionRepository;

    @Override
    public List<RegionResponse> list(RegionRequest regionRequest) {
        if (CommonUtils.isEmpty(regionRequest.getParentNo())) {
            regionRequest.setParentNo(NO_PARENT_ID);
        }
        List<RegionVo> regions = regionMapper.listRegion(regionRequest.convert(RegionQueryBo::new));
        return regions.stream()
                .map(region -> region.convert(RegionResponse.class))
                .collect(Collectors.toList());
    }

    /**
     * 查询省市区树
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Cacheable(cacheNames = "region", key = "'_region_tree'")
    public List<RegionResponse> tree() {
        List<RegionEntity> regions = regionRepository.findByParentNo(NO_PARENT_ID);
        return regions.stream()
                .map(region -> queryTree(region.convert(RegionResponse.class), DISTRICT_LEVEL))
                .collect(Collectors.toList());
    }

    /**
     * 查询树
     */
    private RegionResponse queryTree(RegionResponse regionResponse, int level) {
        if (regionResponse.getLevel() < level) { // 区级
            List<RegionEntity> regions = regionRepository.findByParentNo(regionResponse.getNo());
            regionResponse = regionResponse.setRegionList(
                    regions.stream()
                            .map(region -> queryTree(region.convert(RegionResponse.class), DISTRICT_LEVEL))
                            .collect(Collectors.toList()));
        }
        return regionResponse;
    }

}
