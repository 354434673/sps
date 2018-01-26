package org.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;

public class SpsGoodShop implements Serializable {
    private String categoryName;
    private String companyName;
    private String adminNum;
    private String gForceOpinion;

    private String gSkuIds;

    private String gOpinion;

    private Integer gId;

    private String gCategoryIds;

    private Integer gBrandId;

    private String gSpuNo;

    private String gSpuName;

    private Integer gCategorySelf;

    private String gRecommend;

    private String gUnit;

    private String gGroundingFlag;

    private Date gCreateTime;

    private Integer gShopId;

    private Integer gDeleteFlag;

    private Integer gStatus;

    private Date gUpdateTime;


    public String getgSkuIds() {
        return gSkuIds;
    }

    public void setgSkuIds(String gSkuIds) {
        this.gSkuIds = gSkuIds;
    }

    public String getgForceOpinion() {
        return gForceOpinion;
    }

    public void setgForceOpinion(String gForceOpinion) {
        this.gForceOpinion = gForceOpinion;
    }

    public String getgOpinion() {
        return gOpinion;
    }

    public void setgOpinion(String gOpinion) {
        this.gOpinion = gOpinion;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(String adminNum) {
        this.adminNum = adminNum;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgCategoryIds() {
        return gCategoryIds;
    }

    public void setgCategoryIds(String gCategoryIds) {
        this.gCategoryIds = gCategoryIds == null ? null : gCategoryIds.trim();
    }

    public Integer getgBrandId() {
        return gBrandId;
    }

    public void setgBrandId(Integer gBrandId) {
        this.gBrandId = gBrandId;
    }

    public String getgSpuNo() {
        return gSpuNo;
    }

    public void setgSpuNo(String gSpuNo) {
        this.gSpuNo = gSpuNo == null ? null : gSpuNo.trim();
    }

    public String getgSpuName() {
        return gSpuName;
    }

    public void setgSpuName(String gSpuName) {
        this.gSpuName = gSpuName == null ? null : gSpuName.trim();
    }

    public Integer getgCategorySelf() {
        return gCategorySelf;
    }

    public void setgCategorySelf(Integer gCategorySelf) {
        this.gCategorySelf = gCategorySelf;
    }

    public String getgRecommend() {
        return gRecommend;
    }

    public void setgRecommend(String gRecommend) {
        this.gRecommend = gRecommend == null ? null : gRecommend.trim();
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit == null ? null : gUnit.trim();
    }

    public String getgGroundingFlag() {
        return gGroundingFlag;
    }

    public void setgGroundingFlag(String gGroundingFlag) {
        this.gGroundingFlag = gGroundingFlag == null ? null : gGroundingFlag.trim();
    }

    public Date getgCreateTime() {
        return gCreateTime;
    }

    public void setgCreateTime(Date gCreateTime) {
        this.gCreateTime = gCreateTime;
    }

    public Integer getgShopId() {
        return gShopId;
    }

    public void setgShopId(Integer gShopId) {
        this.gShopId = gShopId;
    }

    public Integer getgDeleteFlag() {
        return gDeleteFlag;
    }

    public void setgDeleteFlag(Integer gDeleteFlag) {
        this.gDeleteFlag = gDeleteFlag;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Date getgUpdateTime() {
        return gUpdateTime;
    }

    public void setgUpdateTime(Date gUpdateTime) {
        this.gUpdateTime = gUpdateTime;
    }
}