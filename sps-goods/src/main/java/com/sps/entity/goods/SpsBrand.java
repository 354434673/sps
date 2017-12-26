package com.sps.entity.goods;

import java.util.Date;

public class SpsBrand {
    private Integer brandId;

    private String brandCategoryIds;

    private String brandAbbreviation;

    private String brandDes;

    private String brandSmallUrl;

    private String brandBigUrl;

    private Integer brandDeleteFlag;

    private Date brandCreateTime;

    private Date brandUpdateTime;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandCategoryIds() {
        return brandCategoryIds;
    }

    public void setBrandCategoryIds(String brandCategoryIds) {
        this.brandCategoryIds = brandCategoryIds == null ? null : brandCategoryIds.trim();
    }

    public String getBrandAbbreviation() {
        return brandAbbreviation;
    }

    public void setBrandAbbreviation(String brandAbbreviation) {
        this.brandAbbreviation = brandAbbreviation == null ? null : brandAbbreviation.trim();
    }

    public String getBrandDes() {
        return brandDes;
    }

    public void setBrandDes(String brandDes) {
        this.brandDes = brandDes == null ? null : brandDes.trim();
    }

    public String getBrandSmallUrl() {
        return brandSmallUrl;
    }

    public void setBrandSmallUrl(String brandSmallUrl) {
        this.brandSmallUrl = brandSmallUrl == null ? null : brandSmallUrl.trim();
    }

    public String getBrandBigUrl() {
        return brandBigUrl;
    }

    public void setBrandBigUrl(String brandBigUrl) {
        this.brandBigUrl = brandBigUrl == null ? null : brandBigUrl.trim();
    }

    public Integer getBrandDeleteFlag() {
        return brandDeleteFlag;
    }

    public void setBrandDeleteFlag(Integer brandDeleteFlag) {
        this.brandDeleteFlag = brandDeleteFlag;
    }

    public Date getBrandCreateTime() {
        return brandCreateTime;
    }

    public void setBrandCreateTime(Date brandCreateTime) {
        this.brandCreateTime = brandCreateTime;
    }

    public Date getBrandUpdateTime() {
        return brandUpdateTime;
    }

    public void setBrandUpdateTime(Date brandUpdateTime) {
        this.brandUpdateTime = brandUpdateTime;
    }
}