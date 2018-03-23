package com.sps.entity.merchant;

import java.io.Serializable;
import java.math.BigDecimal;

public class SpsChannelFinanceTarget implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

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