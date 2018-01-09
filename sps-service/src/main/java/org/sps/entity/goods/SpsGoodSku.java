package org.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;

public class SpsGoodSku implements Serializable {
    private Integer gId;

    private String gColor;

    private String gSize;

    private String gNo;

    private Long gPrice;

    private String gType;

    private Double gScale;

    private Long gBprice;

    private Long gAprice;

    private Integer gGid;

    private Date gCreateTime;

    private Date gUpdateTime;

    private Integer gDeleteFlag;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
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

    public String getgNo() {
        return gNo;
    }

    public void setgNo(String gNo) {
        this.gNo = gNo == null ? null : gNo.trim();
    }

    public Long getgPrice() {
        return gPrice;
    }

    public void setgPrice(Long gPrice) {
        this.gPrice = gPrice;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType == null ? null : gType.trim();
    }

    public Double getgScale() {
        return gScale;
    }

    public void setgScale(Double gScale) {
        this.gScale = gScale;
    }

    public Long getgBprice() {
        return gBprice;
    }

    public void setgBprice(Long gBprice) {
        this.gBprice = gBprice;
    }

    public Long getgAprice() {
        return gAprice;
    }

    public void setgAprice(Long gAprice) {
        this.gAprice = gAprice;
    }

    public Integer getgGid() {
        return gGid;
    }

    public void setgGid(Integer gGid) {
        this.gGid = gGid;
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
}