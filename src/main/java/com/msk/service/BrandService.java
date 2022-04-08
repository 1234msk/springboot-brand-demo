package com.msk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msk.pojo.Brand;

public interface BrandService extends IService<Brand> {

    boolean saveBrand(Brand brand);

    boolean updateBrand(Brand brand);

    IPage<Brand> getPage(int currentPage,int pageSize,Brand brand);

    boolean deleteBrand(Brand brand);

    String getCount(Brand brand);
}
