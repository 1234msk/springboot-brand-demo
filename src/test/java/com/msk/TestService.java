package com.msk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msk.pojo.Brand;
import com.msk.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
public class TestService {

    @Autowired
    protected BrandService brandService;

    @Test
    public void TestSelect(){
        IPage<Brand> iPage = new Page<>(3,5);
        IPage<Brand> page = brandService.page(iPage);
        System.out.println("===========0============");
        System.out.println(page);
        System.out.println("============1===========");
        System.out.println(page.getRecords());
    }

    @Test
    public void TestLamda(){

    }
}
