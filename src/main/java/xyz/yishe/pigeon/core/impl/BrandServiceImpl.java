package xyz.yishe.pigeon.core.impl;

import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.PageResult;
import xyz.yishe.pigeon.common.model.page.PageSupport;
import xyz.yishe.pigeon.core.BrandService;
import xyz.yishe.pigeon.dao.jpa.entity.BrandEntity;
import xyz.yishe.pigeon.dao.mybatis.bo.BrandQueryBo;
import xyz.yishe.pigeon.dao.mybatis.mapper.BrandMapper;
import xyz.yishe.pigeon.dao.mybatis.vo.BrandVo;
import xyz.yishe.pigeon.server.request.BrandQueryRequest;
import xyz.yishe.pigeon.server.response.BrandResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 品牌
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
        List<BrandResponse> list = brandVos.stream().map(brandVo ->
                brandVo.convert(BrandResponse::new)).collect(Collectors.toList());
        PageInfo<BrandResponse> pageInfo = new PageInfo<>(list);
        PageResult<BrandResponse> pageResult = PageSupport.convert(pageInfo);
        return pageResult;
    }

    @Override
    public BrandResponse query(BrandQueryRequest request) {
        Optional<BrandEntity> optional = brandRepository.findById(request.getId());
        if (optional.isPresent()) {
            return null;
        }
        return optional.get().convert(BrandResponse::new);
    }

    /**
     * 新增品牌
     *
     * @param brandForm 品牌
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Brand add(BrandForm brandForm) {
        // 去重
        String parentId = brandForm.getParentId();
        if (CommonUtils.isNotEmpty(parentId)) {
            List<Brand> brandList = brandRepository.findByNameAndParentId(brandForm.getName(), parentId);
            if (CommonUtils.isNotEmpty(brandList)) {
                throw new LogicException("品牌已存在");
            }
        } else {
            List<Brand> brandList = brandRepository.findByNameAndParentIdIsNull(brandForm.getName());
            if (CommonUtils.isNotEmpty(brandList)) {
                throw new LogicException("品牌已存在");
            }
        }

        // 新增
        return brandRepository.save(
                brandForm.convert(Brand::new)
                        .setId(createId())
                        .setDelFlag(UN_DEL.getValue()));
    }

    /**
     * 修改品牌
     *
     * @param brandForm 品牌信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Brand update(UpdateBrandForm brandForm) {
        String brandId = brandForm.getId();
        Brand brand = load(brandId);
        BeanUtils.copyProperties(brandForm, brand);
        String parentId = brand.getParentId();
        if (CommonUtils.isNotEmpty(parentId)) {
            List<Brand> brandList = brandRepository.findByNameAndParentId(brandForm.getName(), parentId);
            if (CommonUtils.isNotEmpty(brandList) && !brandList.get(0).getId().equals(brandId)) {
                throw new LogicException("品牌已存在");
            }
        } else {
            List<Brand> brandList = brandRepository.findByNameAndParentIdIsNull(brandForm.getName());
            if (CommonUtils.isNotEmpty(brandList) && !brandList.get(0).getId().equals(brandId)) {
                throw new LogicException("品牌已存在");
            }
        }

        return brandRepository.save(brand);
    }

    /**
     * 删除品牌
     *
     * @param brandForm 品牌信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(BrandForm brandForm) {
        Brand brand = load(brandForm.getId());
        brand.setDelFlag(DelFlagEnum.DEL.getValue());
        // 判断型号有没有使用
        checkUse(brand);
        brandRepository.save(brand);
    }
}
