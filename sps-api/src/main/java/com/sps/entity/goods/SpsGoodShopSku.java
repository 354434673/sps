package com.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsGoodShopSku implements Serializable {
    private String spuName;
    private String sizeColor;


    private Integer gId;
    private Integer gGoodsId;
    private Integer gGid;

    private String gColor;

    private String gSize;

    private String gSku;

    private BigDecimal gPrice;

    private Integer gQuantity;

    private Integer gStock;

    private Double gScale;

    private BigDecimal gService;

    private Integer gDeleteFlag;

    private Integer gSkuId;
    private Date gCreateTime;

    private Date gUpdateTime;


    public String getSizeColor() {
        return sizeColor;
    }

    public void setSizeColor(String sizeColor) {
        this.sizeColor = sizeColor;
    }

    public Integer getgGoodsId() {
        return gGoodsId;
    }

    public void setgGoodsId(Integer gGoodsId) {
        this.gGoodsId = gGoodsId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Date getgCreateTime() {
        return gCreateTime;
    }

    public void setgCreateTime(Date gCreateTime) {
        this.gCreateTime = gCreateTime;
    }

    public Date getgUpdateTime() {
        return gUpdateTime;
    }

    public void setgUpdateTime(Date gUpdateTime) {
        this.gUpdateTime = gUpdateTime;
    }

    public Integer getgDeleteFlag() {
        return gDeleteFlag;
    }

    public void setgDeleteFlag(Integer gDeleteFlag) {
        this.gDeleteFlag = gDeleteFlag;
    }

    public Integer getgSkuId() {
        return gSkuId;
    }

    public void setgSkuId(Integer gSkuId) {
        this.gSkuId = gSkuId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getgGid() {
        return gGid;
    }

    public void setgGid(Integer gGid) {
        this.gGid = gGid;
    }

    public String getgColor() {
        return gColor;
    }

    public void setgColor(String gColor) {
        this.gColor = gColor == null ? null : gColor.trim();
    }

    public String getgSize() {
        return gSize;
    }

    public void setgSize(String gSize) {
        this.gSize = gSize == null ? null : gSize.trim();
    }

    public String getgSku() {
        return gSku;
    }

    public void setgSku(String gSku) {
        this.gSku = gSku == null ? null : gSku.trim();
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public Integer getgQuantity() {
        return gQuantity;
    }

    public void setgQuantity(Integer gQuantity) {
        this.gQuantity = gQuantity;
    }

    public Integer getgStock() {
        return gStock;
    }

    public void setgStock(Integer gStock) {
        this.gStock = gStock;
    }

    public Double getgScale() {
        return gScale;
    }

    public void setgScale(Double gScale) {
        this.gScale = gScale;
    }

    public BigDecimal getgService() {
        return gService;
    }

    public void setgService(BigDecimal gService) {
        this.gService = gService;
    }
}