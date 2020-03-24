package xyz.yishe.pigeon.core.impl;

import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.PageResult;
import xyz.yishe.pigeon.common.model.page.PageSupport;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.core.BrandService;
import xyz.yishe.pigeon.dao.jpa.entity.BrandEntity;
import xyz.yishe.pigeon.dao.jpa.repository.BrandRepository;
import xyz.yishe.pigeon.dao.mybatis.bo.BrandQueryBo;
import xyz.yishe.pigeon.dao.mybatis.mapper.BrandMapper;
import xyz.yishe.pigeon.dao.mybatis.vo.BrandVo;
import xyz.yishe.pigeon.server.request.BrandQueryRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 品牌业务类
 *
 * @author aotianpan
 * @date 2020-03-21 5:30 下午
 */
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public PageResult<BrandResponse> pageQuery(PageQuery<BrandQueryRequest> pageQuery) {
        BrandQueryRequest queryRequest = pageQuery.getConditions();
        List<BrandVo> brandVos = brandMapper.listBrand(queryRequest.convert(BrandQueryBo::new));
        List<BrandResponse> list = brandVos.stream()
                .map(brandVo -> brandVo.convert(BrandResponse::new))
                .collect(Collectors.toList());
        PageInfo<BrandResponse> pageInfo = new PageInfo<>(list);
        PageResult<BrandResponse> pageResult = PageSupport.convert(pageInfo);
        return pageResult;
    }

    @Override
    public BrandResponse detail(String brandId) {
        BrandEntity brandEntity = brandRepository.findById(brandId).orElse(null);
        if (CommonUtils.isEmpty(brandEntity)) {
            return null;
        }
        return brandEntity.convert(BrandResponse::new);
    }
}
