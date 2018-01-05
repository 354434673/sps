package org.sps.entity.merchant;

public class SpsChannelEnterprise {
    private Integer enterpriseId;

    private String enterpriseBusinesslicenseNo;

    private String enterpriseCompanyName;

    private String enterpriseCompanyRegisterAddr;

    private String enterpriseCompanyRealitAddr;

    private String enterpriseCorp;

    private Integer enterpriseOperatioTime;

    private Integer enterpriseEmployeeNum;

    private String channelNum;

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