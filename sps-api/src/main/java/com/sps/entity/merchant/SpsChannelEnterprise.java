package com.sps.entity.merchant;

import com.sps.entity.goods.SpsCustomCategory;
import com.sps.entity.goods.SpsGoodShop;

import java.io.Serializable;
import java.util.List;

public class SpsChannelEnterprise implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

    private List<SpsCustomCategory> customCategoryList;
    private List<SpsGoodShop> goodShops;
	private Integer enterpriseId;

    private String enterpriseBusinesslicenseNo;

    private String enterpriseCompanyName;
    
    private String enterpriseCompanyAbbreviation;
    
    private String enterpriseCompanyRegisterAddr;

    private String enterpriseCompanyRealitAddr;

    private String enterpriseCorp;
    
    private String enterpriseCorpIdcard;

    private Integer enterpriseOperatioTime;

    private Integer enterpriseEmployeeNum;

    private String channelNum;
    
    private SpsChannelBusiness business;
    
    private SpsChannelPic pic;
    
    private SpsChannelGuarantee guarantee;


    public List<SpsCustomCategory> getCustomCategoryList() {
        return customCategoryList;
    }

    public void setCustomCategoryList(List<SpsCustomCategory> customCategoryList) {
        this.customCategoryList = customCategoryList;
    }

    public List<SpsGoodShop> getGoodShops() {
        return goodShops;
    }

    public void setGoodShops(List<SpsGoodShop> goodShops) {
        this.goodShops = goodShops;
    }

    public SpsChannelGuarantee getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(SpsChannelGuarantee guarantee) {
		this.guarantee = guarantee;
	}

	public SpsChannelPic getPic() {
		return pic;
	}

	public void setPic(SpsChannelPic pic) {
		this.pic = pic;
	}

	public SpsChannelBusiness getBusiness() {
		return business;
	}

	public void setBusiness(SpsChannelBusiness business) {
		this.business = business;
	}

	public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseBusinesslicenseNo() {
        return enterpriseBusinesslicenseNo;
    }

    public void setEnterpriseBusinesslicenseNo(String enterpriseBusinesslicenseNo) {
        this.enterpriseBusinesslicenseNo = enterpriseBusinesslicenseNo == null ? null : enterpriseBusinesslicenseNo.trim();
    }

    public String getEnterpriseCompanyName() {
        return enterpriseCompanyName;
    }

    public void setEnterpriseCompanyName(String enterpriseCompanyName) {
        this.enterpriseCompanyName = enterpriseCompanyName == null ? null : enterpriseCompanyName.trim();
    }

    public String getEnterpriseCompanyAbbreviation() {
        return enterpriseCompanyAbbreviation;
    }

    public void setEnterpriseCompanyAbbreviation(String enterpriseCompanyAbbreviation) {
        this.enterpriseCompanyAbbreviation = enterpriseCompanyAbbreviation == null ? null : enterpriseCompanyAbbreviation.trim();
    }

    public String getEnterpriseCompanyRegisterAddr() {
        return enterpriseCompanyRegisterAddr;
    }

    public void setEnterpriseCompanyRegisterAddr(String enterpriseCompanyRegisterAddr) {
        this.enterpriseCompanyRegisterAddr = enterpriseCompanyRegisterAddr == null ? null : enterpriseCompanyRegisterAddr.trim();
    }

    public String getEnterpriseCompanyRealitAddr() {
        return enterpriseCompanyRealitAddr;
    }

    public void setEnterpriseCompanyRealitAddr(String enterpriseCompanyRealitAddr) {
        this.enterpriseCompanyRealitAddr = enterpriseCompanyRealitAddr == null ? null : enterpriseCompanyRealitAddr.trim();
    }

    public String getEnterpriseCorp() {
        return enterpriseCorp;
    }

    public void setEnterpriseCorp(String enterpriseCorp) {
        this.enterpriseCorp = enterpriseCorp == null ? null : enterpriseCorp.trim();
    }

    public String getEnterpriseCorpIdcard() {
        return enterpriseCorpIdcard;
    }

    public void setEnterpriseCorpIdcard(String enterpriseCorpIdcard) {
        this.enterpriseCorpIdcard = enterpriseCorpIdcard == null ? null : enterpriseCorpIdcard.trim();
    }

    public Integer getEnterpriseOperatioTime() {
        return enterpriseOperatioTime;
    }

    public void setEnterpriseOperatioTime(Integer enterpriseOperatioTime) {
        this.enterpriseOperatioTime = enterpriseOperatioTime;
    }

    public Integer getEnterpriseEmployeeNum() {
        return enterpriseEmployeeNum;
    }

    public void setEnterpriseEmployeeNum(Integer enterpriseEmployeeNum) {
        this.enterpriseEmployeeNum = enterpriseEmployeeNum;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}