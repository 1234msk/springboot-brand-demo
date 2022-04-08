package com.msk;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msk.mapper.BrandMapper;
import com.msk.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void TestSelectAll(){
        List<Brand> brands = brandMapper.selectList(null);
        for (Brand brand:brands){
            System.out.println(brand);
        }
    }
    @Test
    public void TestInsert(){
        Brand brand = new Brand();
        brand.setBrandName("华为");
        brand.setStatus(0);
        brand.setDescription("创造价值");
        brand.setOrdered(56);
        brand.setCompanyName("华为公司");
        int count = brandMapper.insert(brand);
        System.out.println("受影响行数："+count);
        System.out.println("生成的id："+brand.getId());
    }

    @Test
    public void TestSelectByPage(){
        Page<Brand> page = new Page<>(4,5);
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("company_name", "华为");
        Page<Brand> page1 = brandMapper.selectPage(page, queryWrapper);
        System.out.println(page1);
    }

    @Test
    public void TestPage(){
        IPage<Brand> page = new Page(3,5);
        IPage iPage = brandMapper.selectPage(page, null);
        List<Brand> records = iPage.getRecords();
        for (Brand brand:records){
            System.out.println(brand);
        }
        System.out.println("================================");
        System.out.println(iPage);
    }

    @Test
    public void TestDelete(){
        int i = brandMapper.deleteById(132);
        System.out.println("受影响行数："+i);
    }

    @Test
    public void TestUpdate(){
        Brand brand = new Brand();
        brand.setId(112);
        brand.setBrandName("hlkajdsfhj");
        brand.setCompanyName("hlkajdsfhj");
        brand.setDescription("hlkajdsfhj");
        brand.setStatus(1);
        int i = brandMapper.updateById(brand);
        System.out.println("受影响的行数："+i);
    }

    @Test
    public void TestGetPageByCondition(){
        int currentPage = 2;
        int pageSize = 5;
        Brand brand = new Brand();
        brand.setBrandName("华为");
        IPage<Brand> page = new Page<>(currentPage,pageSize);
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(brand.getCompanyName()),Brand::getCompanyName,brand.getCompanyName())
                .like(StringUtils.isNotBlank(brand.getBrandName()),Brand::getBrandName,brand.getBrandName())
                .like(brand.getStatus() != null,Brand::getStatus,brand.getStatus());
        IPage<Brand> iPage = brandMapper.selectPage(page, lambdaQueryWrapper);
        System.out.println(iPage.getRecords());
    }
}
