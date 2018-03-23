package org.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperRepayment implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer repaymentId;

    private String repaymentBankid;

    private String repaymentDepositBank;

    private String repaymentPhone;

    private String shopkeeperCustomerid;

    private String repaymentUsername;

    private Date repaymentCreatTime;

    private Date repaymentUpdateTime;

    public Integer getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Integer repaymentId) {
        this.repaymentId = repaymentId;
    }

    public String getRepaymentBankid() {
        return repaymentBankid;
    }

    public void setRepaymentBankid(String repaymentBankid) {
        this.repaymentBankid = repaymentBankid == null ? null : repaymentBankid.trim();
    }

    public String getRepaymentDepositBank() {
        return repaymentDepositBank;
    }

    public void setRepaymentDepositBank(String repaymentDepositBank) {
        this.repaymentDepositBank = repaymentDepositBank == null ? null : repaymentDepositBank.trim();
    }

    public String getRepaymentPhone() {
        return repaymentPhone;
    }

    public void setRepaymentPhone(String repaymentPhone) {
        this.repaymentPhone = repaymentPhone == null ? null : repaymentPhone.trim();
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getRepaymentUsername() {
        return repaymentUsername;
    }

    public void setRepaymentUsername(String repaymentUsername) {
        this.repaymentUsername = repaymentUsername == null ? null : repaymentUsername.trim();
    }

    public Date getRepaymentCreatTime() {
        return repaymentCreatTime;
    }

    public void setRepaymentCreatTime(Date repaymentCreatTime) {
        this.repaymentCreatTime = repaymentCreatTime;
    }

    public Date getRepaymentUpdateTime() {
        return repaymentUpdateTime;
    }

    public void setRepaymentUpdateTime(Date repaymentUpdateTime) {
        this.repaymentUpdateTime = repaymentUpdateTime;
    }
}