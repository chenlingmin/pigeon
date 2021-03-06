package xyz.yishe.pigeon.core.impl;

import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.model.enums.DelFlagEnum;
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
import xyz.yishe.pigeon.server.request.BrandRequest;
import xyz.yishe.pigeon.server.request.UpdateBrandRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

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

    /**
     * 根据品牌编号获取品牌信息
     *
     * @param brandId 品牌编号
     * @return
     */
    public BrandEntity load(String brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new BizException(format("品牌不存在, 品牌编号:%s", brandId)));
    }

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

    /**
     * 新增品牌
     *
     * @param brandRequest 品牌
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BrandResponse add(BrandRequest brandRequest) {
        // 去重
        String parentId = brandRequest.getParentId();
        if (CommonUtils.isNotEmpty(parentId)) {
            List<BrandEntity> brandList = brandRepository.findByNameAndParentId(brandRequest.getName(), parentId);
            if (CommonUtils.isNotEmpty(brandList)) {
                throw new BizException("品牌已存在");
            }
        } else {
            List<BrandEntity> brandList = brandRepository.findByNameAndParentIdIsNull(brandRequest.getName());
            if (CommonUtils.isNotEmpty(brandList)) {
                throw new BizException("品牌已存在");
            }
        }

        // 新增
        BrandEntity brandEntity = brandRepository.save(
                brandRequest.convert(BrandEntity::new)
                        .setDelFlag(DelFlagEnum.UN_DEL.getValue()));
        return brandEntity.convert(BrandResponse::new);
    }

    /**
     * 修改品牌
     *
     * @param brandRequest 品牌信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BrandResponse update(UpdateBrandRequest brandRequest) {
        String brandId = brandRequest.getId();
        BrandEntity brand = load(brandId);
        BeanUtils.copyProperties(brandRequest, brand);
        String parentId = brand.getParentId();
        if (CommonUtils.isNotEmpty(parentId)) {
            List<BrandEntity> brandList = brandRepository.findByNameAndParentId(brandRequest.getName(), parentId);
            if (CommonUtils.isNotEmpty(brandList) && !brandList.get(0).getId().equals(brandId)) {
                throw new BizException("品牌已存在");
            }
        } else {
            List<BrandEntity> brandList = brandRepository.findByNameAndParentIdIsNull(brandRequest.getName());
            if (CommonUtils.isNotEmpty(brandList) && !brandList.get(0).getId().equals(brandId)) {
                throw new BizException("品牌已存在");
            }
        }

        brand = brandRepository.save(brand);
        return brand.convert(BrandResponse::new);
    }

    /**
     * 删除品牌
     *
     * @param brandForm 品牌信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(BrandRequest brandForm) {
        BrandEntity brand = load(brandForm.getId());
        brand.setDelFlag(DelFlagEnum.DEL.getValue());
        brandRepository.save(brand);
    }
}
