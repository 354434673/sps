package org.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;

public class SpsSaleLog implements Serializable {
    private Integer saleId;

    private Integer saleGoodId;

    private String saleContent;

    private Date saleCreateTime;

    private Date saleUpdateTime;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getSaleGoodId() {
        return saleGoodId;
    }

    public void setSaleGoodId(Integer saleGoodId) {
        this.saleGoodId = saleGoodId;
    }

    public String getSaleContent() {
        return saleContent;
    }

    public void setSaleContent(String saleContent) {
        this.saleContent = saleContent == null ? null : saleContent.trim();
    }

    public Date getSaleCreateTime() {
        return saleCreateTime;
    }

    public void setSaleCreateTime(Date saleCreateTime) {
        this.saleCreateTime = saleCreateTime;
    }

    public Date getSaleUpdateTime() {
        return saleUpdateTime;
    }

    public void setSaleUpdateTime(Date saleUpdateTime) {
        this.saleUpdateTime = saleUpdateTime;
    }
}