package com.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SpsGoodShop implements Serializable {
    private String gForceOpinion;
    private String gSkuIds;
    private String gOpinion;
    private Integer gGoodsId;
    private Integer gId;
    private String gRemark;
    private String gDetails;
    private Integer gSalesNum;
    private String gCategoryIds;

    private String gPic;

    private Integer gBrandId;

    private String gSpuNo;

    private String gSpuName;

    private Integer gCategorySelf;

    private String gRecommend;

    private String gUnit;

    private String gGroundingFlag;

    private Date gCreateTime;

    private String gShopId;

    private Integer gDeleteFlag;

    private Integer gStatus;

    private Date gUpdateTime;

    private BigDecimal gMinPrice;


    private List<SpsGoodsAlbum> albumList;
    private List<SpsGoodsAlbum> albumDetailList;

    public String getgForceOpinion() {
        return gForceOpinion;
    }

    public void setgForceOpinion(String gForceOpinion) {
        this.gForceOpinion = gForceOpinion;
    }

    public String getgSkuIds() {
        return gSkuIds;
    }

    public void setgSkuIds(String gSkuIds) {
        this.gSkuIds = gSkuIds;
    }

    public String getgOpinion() {
        return gOpinion;
    }

    public void setgOpinion(String gOpinion) {
        this.gOpinion = gOpinion;
    }

    public Integer getgGoodsId() {
        return gGoodsId;
    }

    public void setgGoodsId(Integer gGoodsId) {
        this.gGoodsId = gGoodsId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgRemark() {
        return gRemark;
    }

    public void setgRemark(String gRemark) {
        this.gRemark = gRemark;
    }

    public String getgDetails() {
        return gDetails;
    }

    public void setgDetails(String gDetails) {
        this.gDetails = gDetails;
    }

    public Integer getgSalesNum() {
        return gSalesNum;
    }

    public void setgSalesNum(Integer gSalesNum) {
        this.gSalesNum = gSalesNum;
    }

    public String getgCategoryIds() {
        return gCategoryIds;
    }

    public void setgCategoryIds(String gCategoryIds) {
        this.gCategoryIds = gCategoryIds;
    }

    public String getgPic() {
        return gPic;
    }

    public void setgPic(String gPic) {
        this.gPic = gPic;
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
        this.gSpuNo = gSpuNo;
    }

    public String getgSpuName() {
        return gSpuName;
    }

    public void setgSpuName(String gSpuName) {
        this.gSpuName = gSpuName;
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
        this.gRecommend = gRecommend;
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit;
    }

    public String getgGroundingFlag() {
        return gGroundingFlag;
    }

    public void setgGroundingFlag(String gGroundingFlag) {
        this.gGroundingFlag = gGroundingFlag;
    }

    public Date getgCreateTime() {
        return gCreateTime;
    }

    public void setgCreateTime(Date gCreateTime) {
        this.gCreateTime = gCreateTime;
    }

    public String getgShopId() {
        return gShopId;
    }

    public void setgShopId(String gShopId) {
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

    public BigDecimal getgMinPrice() {
        return gMinPrice;
    }

    public void setgMinPrice(BigDecimal gMinPrice) {
        this.gMinPrice = gMinPrice;
    }

    public List<SpsGoodsAlbum> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<SpsGoodsAlbum> albumList) {
        this.albumList = albumList;
    }

    public List<SpsGoodsAlbum> getAlbumDetailList() {
        return albumDetailList;
    }

    public void setAlbumDetailList(List<SpsGoodsAlbum> albumDetailList) {
        this.albumDetailList = albumDetailList;
    }
}