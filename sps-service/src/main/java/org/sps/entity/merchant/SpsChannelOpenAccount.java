package org.sps.entity.merchant;

import java.io.Serializable;
import java.util.Date;

public class SpsChannelOpenAccount implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer openId;

    private String openAdminNum;

    private String openAdminPhone;

    private String openStartTime;

    private String openEndTime;

    private String openApplyProduct;

    private Integer openSellRate;

    private String channelNum;

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public String getOpenAdminNum() {
        return openAdminNum;
    }

    public void setOpenAdminNum(String openAdminNum) {
        this.openAdminNum = openAdminNum == null ? null : openAdminNum.trim();
    }

    public String getOpenAdminPhone() {
        return openAdminPhone;
    }

    public void setOpenAdminPhone(String openAdminPhone) {
        this.openAdminPhone = openAdminPhone == null ? null : openAdminPhone.trim();
    }

    public String getOpenStartTime() {
        return openStartTime;
    }

    public void setOpenStartTime(String openStartTime) {
        this.openStartTime = openStartTime;
    }

    public String getOpenEndTime() {
        return openEndTime;
    }

    public void setOpenEndTime(String openEndTime) {
        this.openEndTime = openEndTime;
    }

    public String getOpenApplyProduct() {
        return openApplyProduct;
    }

    public void setOpenApplyProduct(String openApplyProduct) {
        this.openApplyProduct = openApplyProduct == null ? null : openApplyProduct.trim();
    }

    public Integer getOpenSellRate() {
        return openSellRate;
    }

    public void setOpenSellRate(Integer openSellRate) {
        this.openSellRate = openSellRate;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
    
}