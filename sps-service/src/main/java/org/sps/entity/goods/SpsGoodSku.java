package org.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsGoodSku implements Serializable {

    private String supName;

    private Integer gId;

    private String gColor;

    private String gSize;

    private String gNo;

    private BigDecimal gPrice;

    private String gType;

    private Double gScale;

    private BigDecimal gBprice;

    private BigDecimal gAprice;

    private Integer gGid;

    private Date gCreateTime;

    private Date gUpdateTime;

    private Integer gDeleteFlag;


    private BigDecimal gBeforePrice;

    private Date gAuditTime;

    private Integer gAuditStatus;

    public BigDecimal getgBeforePrice() {
        return gBeforePrice;
    }

    public void setgBeforePrice(BigDecimal gBeforePrice) {
        this.gBeforePrice = gBeforePrice;
    }

    public Date getgAuditTime() {
        return gAuditTime;
    }

    public void setgAuditTime(Date gAuditTime) {
        this.gAuditTime = gAuditTime;
    }

    public Integer getgAuditStatus() {
        return gAuditStatus;
    }

    public void setgAuditStatus(Integer gAuditStatus) {
        this.gAuditStatus = gAuditStatus;
    }

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

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public BigDecimal getgBprice() {
        return gBprice;
    }

    public void setgBprice(BigDecimal gBprice) {
        this.gBprice = gBprice;
    }

    public BigDecimal getgAprice() {
        return gAprice;
    }

    public void setgAprice(BigDecimal gAprice) {
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

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }
}