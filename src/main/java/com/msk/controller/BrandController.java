package com.msk.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msk.controller.utils.R;
import com.msk.pojo.Brand;
import com.msk.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //相当于@Controller + @ResponseBody
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    //分页条件查询
    @RequestMapping("/selectByPage")
    public R selectByPage(String currentPage, String pageSize, @RequestBody Brand brand){
        IPage<Brand> page = brandService.getPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize), brand);

        if (page.getPages() < Integer.parseInt(currentPage)){
            return new R(true,brandService.getPage((int) page.getPages(), Integer.parseInt(pageSize), brand));
        }
        return new R(true,page);
    }

    //查询所有
    @RequestMapping("/selectAll")
    public R getAll(){
        return new R(true,brandService.list());
    }

    //添加
    @RequestMapping("/addBrand")
    public R addBrand(@RequestBody Brand brand){
        boolean flag = brandService.saveBrand(brand);
        return new R(flag,flag ? "添加成功" : "添加失败");
    }

    //根据ID删除
    @RequestMapping("/deleteBrandById")
    public R deleteBrandById(@RequestBody Brand brand){
        boolean flag = brandService.deleteBrand(brand);
        return new R(flag,flag ? "删除成功" : "删除失败");
    }

    //批量删除
    @RequestMapping("/deleteBrands")
    public R deleteBrands(@RequestBody List<Brand> brandList){
        boolean flag = false;
        for (Brand brand : brandList){
            flag = brandService.deleteBrand(brand);
        }
        return new R(flag,flag ? "删除成功" : "删除失败");
    }

    //修改
    @RequestMapping("/updateBrand")
    public R updateBrand(@RequestBody Brand brand){
        boolean flag = brandService.updateBrand(brand);
        return new R(flag,flag ? "修改成功" : "修改失败");
    }

    //查询总记录数
    @RequestMapping("/getCount")
    public R getCount(@RequestBody Brand brand){
        return new R(true,brandService.getCount(brand));
    }
}
