package com.sps.entity.merchant;

import java.io.Serializable;
import java.util.List;

import com.sps.entity.goods.SpsGoodShop;

public class SpsChannelBusiness implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer businessId;

    private String businessProduct;

    private String businessType;

    private String businessBrand;

    private String businessScope;

    private String channelNum;
    
    private List<SpsGoodShop> goodShops;
    
    
    
    

    public List<SpsGoodShop> getGoodShops() {
		return goodShops;
	}

	public void setGoodShops(List<SpsGoodShop> goodShops) {
		this.goodShops = goodShops;
	}

	public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessProduct() {
        return businessProduct;
    }

    public void setBusinessProduct(String businessProduct) {
        this.businessProduct = businessProduct == null ? null : businessProduct.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessBrand() {
        return businessBrand;
    }

    public void setBusinessBrand(String businessBrand) {
        this.businessBrand = businessBrand == null ? null : businessBrand.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}