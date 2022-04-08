package com.msk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msk.mapper.BrandMapper;
import com.msk.pojo.Brand;
import com.msk.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public boolean saveBrand(Brand brand) {
        return brandMapper.insert(brand) > 0;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return brandMapper.updateById(brand) > 0;
    }

    @Override
    public IPage<Brand> getPage(int currentPage, int pageSize,Brand brand) {
        IPage<Brand> page = new Page<>(currentPage,pageSize);
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(brand.getCompanyName()),Brand::getCompanyName,brand.getCompanyName())
                .like(StringUtils.isNotBlank(brand.getBrandName()),Brand::getBrandName,brand.getBrandName())
                .like(brand.getStatus() != null,Brand::getStatus,brand.getStatus());

        return brandMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public boolean deleteBrand(Brand brand) {
        return brandMapper.deleteById(brand.getId()) > 0;
    }

    @Override
    public String getCount(Brand brand) {
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(brand.getCompanyName()),Brand::getCompanyName,brand.getCompanyName())
                .like(StringUtils.isNotBlank(brand.getBrandName()),Brand::getBrandName,brand.getBrandName())
                .like(brand.getStatus() != null,Brand::getStatus,brand.getStatus());
        Integer count = brandMapper.selectCount(lambdaQueryWrapper);
        return String.valueOf(count);
    }
}
