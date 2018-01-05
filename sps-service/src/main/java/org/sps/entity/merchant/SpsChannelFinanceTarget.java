package org.sps.entity.merchant;

import java.math.BigDecimal;

public class SpsChannelFinanceTarget {
    private Integer targetId;

    private BigDecimal targetLastSale;

    private String channelNum;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public BigDecimal getTargetLastSale() {
        return targetLastSale;
    }

    public void setTargetLastSale(BigDecimal targetLastSale) {
        this.targetLastSale = targetLastSale;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}