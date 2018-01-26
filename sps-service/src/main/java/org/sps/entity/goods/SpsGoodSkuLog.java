package org.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsGoodSkuLog  implements Serializable{
    private Integer gId;

    private Date gCreateTime;

    private Date gUpdateTime;

    private BigDecimal gBeforePrice;

    private BigDecimal gAfterPrice;

    private String gSkuNo;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
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

    public BigDecimal getgBeforePrice() {
        return gBeforePrice;
    }

    public void setgBeforePrice(BigDecimal gBeforePrice) {
        this.gBeforePrice = gBeforePrice;
    }

    public BigDecimal getgAfterPrice() {
        return gAfterPrice;
    }

    public void setgAfterPrice(BigDecimal gAfterPrice) {
        this.gAfterPrice = gAfterPrice;
    }

    public String getgSkuNo() {
        return gSkuNo;
    }

    public void setgSkuNo(String gSkuNo) {
        this.gSkuNo = gSkuNo == null ? null : gSkuNo.trim();
    }
}