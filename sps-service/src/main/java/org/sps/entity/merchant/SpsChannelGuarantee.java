package org.sps.entity.merchant;

import java.io.Serializable;
import java.math.BigDecimal;

public class SpsChannelGuarantee implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer guaranteeId;

    private String guaranteeSituation;

    private BigDecimal guaranteeDeposit;

    private String guaranteeCorpPhone;

    private String guaranteeFinanceContactname;

    private String guaranteeFinanceContactphone;

    private String guaranteeBusinessLeadername;

    private String guaranteeBusinessLeaderphone;

    private String guaranteeBusinessPhonePassword;

    private String channelNum;

    public Integer getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getGuaranteeSituation() {
        return guaranteeSituation;
    }

    public void setGuaranteeSituation(String guaranteeSituation) {
        this.guaranteeSituation = guaranteeSituation == null ? null : guaranteeSituation.trim();
    }

    public BigDecimal getGuaranteeDeposit() {
        return guaranteeDeposit;
    }

    public void setGuaranteeDeposit(BigDecimal guaranteeDeposit) {
        this.guaranteeDeposit = guaranteeDeposit;
    }

    public String getGuaranteeCorpPhone() {
        return guaranteeCorpPhone;
    }

    public void setGuaranteeCorpPhone(String guaranteeCorpPhone) {
        this.guaranteeCorpPhone = guaranteeCorpPhone == null ? null : guaranteeCorpPhone.trim();
    }

    public String getGuaranteeFinanceContactname() {
        return guaranteeFinanceContactname;
    }

    public void setGuaranteeFinanceContactname(String guaranteeFinanceContactname) {
        this.guaranteeFinanceContactname = guaranteeFinanceContactname == null ? null : guaranteeFinanceContactname.trim();
    }

    public String getGuaranteeFinanceContactphone() {
        return guaranteeFinanceContactphone;
    }

    public void setGuaranteeFinanceContactphone(String guaranteeFinanceContactphone) {
        this.guaranteeFinanceContactphone = guaranteeFinanceContactphone == null ? null : guaranteeFinanceContactphone.trim();
    }

    public String getGuaranteeBusinessLeadername() {
        return guaranteeBusinessLeadername;
    }

    public void setGuaranteeBusinessLeadername(String guaranteeBusinessLeadername) {
        this.guaranteeBusinessLeadername = guaranteeBusinessLeadername == null ? null : guaranteeBusinessLeadername.trim();
    }

    public String getGuaranteeBusinessLeaderphone() {
        return guaranteeBusinessLeaderphone;
    }

    public void setGuaranteeBusinessLeaderphone(String guaranteeBusinessLeaderphone) {
        this.guaranteeBusinessLeaderphone = guaranteeBusinessLeaderphone == null ? null : guaranteeBusinessLeaderphone.trim();
    }

    public String getGuaranteeBusinessPhonePassword() {
        return guaranteeBusinessPhonePassword;
    }

    public void setGuaranteeBusinessPhonePassword(String guaranteeBusinessPhonePassword) {
        this.guaranteeBusinessPhonePassword = guaranteeBusinessPhonePassword == null ? null : guaranteeBusinessPhonePassword.trim();
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}