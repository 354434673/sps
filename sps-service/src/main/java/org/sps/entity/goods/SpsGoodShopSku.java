package org.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;

public class SpsGoodShopSku implements Serializable {
    private Integer gId;

    private Integer gGid;

    private String gColor;

    private String gSize;

    private String gSku;

    private Long gPrice;

    private Integer gQuantity;

    private Integer gStock;

    private Double gScale;

    private BigDecimal gService;

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

    public Long getgPrice() {
        return gPrice;
    }

    public void setgPrice(Long gPrice) {
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