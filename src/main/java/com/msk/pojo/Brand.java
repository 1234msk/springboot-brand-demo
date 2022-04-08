package com.msk.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 品牌实体类
 */
@Data
@TableName("tb_brand")
public class Brand {
    // id 主键
    @TableId("id")
    private Integer id;
    // 品牌名称
    @TableField("brand_name")
    private String brandName;
    // 企业名称
    @TableField("company_name")
    private String companyName;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    private String statusStr;
    //逻辑视图
    public String getStatusStr() {
        return status==0 ? "禁用":"启用";
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }


}
