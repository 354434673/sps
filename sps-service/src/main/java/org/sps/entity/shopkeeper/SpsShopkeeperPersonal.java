package org.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperPersonal implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer personalId;

    private String personalClientName;

    private String personalSex;

    private String personalIdcard;

    private String personalIdcardValidityStart;

    private String personalIdcardValidityEnd;

    private String personalLicenceIssuingAuthority;

    private Integer personalAge;

    private String personalMaritalStatus;

    private String personalPhone;

    private String personalPhonePassword;

    private String personalPlaceofdomicile;

    private String personalLivingCondition;

    private String personalLivingConditionOther;

    private String personalLivingProvinceName;

    private String personalLivingProvinceCode;

    private String personalLivingCityName;

    private String personalLivingCityCode;

    private String personalLivingAreaName;

    private String personalLivingAreaCode;

    private String personalLivingAddress;

    private String personalNoneCorp;

    private String personalNickname;

    private String personalUsername;

    private Date personalCreatTime;

    private Date personalUpdateTime;

    private String shopkeeperCustomerid;

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    public String getPersonalClientName() {
        return personalClientName;
    }

    public void setPersonalClientName(String personalClientName) {
        this.personalClientName = personalClientName == null ? null : personalClientName.trim();
    }

    public String getPersonalSex() {
        return personalSex;
    }

    public void setPersonalSex(String personalSex) {
        this.personalSex = personalSex == null ? null : personalSex.trim();
    }

    public String getPersonalIdcard() {
        return personalIdcard;
    }

    public void setPersonalIdcard(String personalIdcard) {
        this.personalIdcard = personalIdcard == null ? null : personalIdcard.trim();
    }

    public String getPersonalIdcardValidityStart() {
        return personalIdcardValidityStart;
    }

    public void setPersonalIdcardValidityStart(String personalIdcardValidityStart) {
        this.personalIdcardValidityStart = personalIdcardValidityStart == null ? null : personalIdcardValidityStart.trim();
    }

    public String getPersonalIdcardValidityEnd() {
        return personalIdcardValidityEnd;
    }

    public void setPersonalIdcardValidityEnd(String personalIdcardValidityEnd) {
        this.personalIdcardValidityEnd = personalIdcardValidityEnd == null ? null : personalIdcardValidityEnd.trim();
    }

    public String getPersonalLicenceIssuingAuthority() {
        return personalLicenceIssuingAuthority;
    }

    public void setPersonalLicenceIssuingAuthority(String personalLicenceIssuingAuthority) {
        this.personalLicenceIssuingAuthority = personalLicenceIssuingAuthority == null ? null : personalLicenceIssuingAuthority.trim();
    }

    public Integer getPersonalAge() {
        return personalAge;
    }

    public void setPersonalAge(Integer personalAge) {
        this.personalAge = personalAge;
    }

    public String getPersonalMaritalStatus() {
        return personalMaritalStatus;
    }

    public void setPersonalMaritalStatus(String personalMaritalStatus) {
        this.personalMaritalStatus = personalMaritalStatus == null ? null : personalMaritalStatus.trim();
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone == null ? null : personalPhone.trim();
    }

    public String getPersonalPhonePassword() {
        return personalPhonePassword;
    }

    public void setPersonalPhonePassword(String personalPhonePassword) {
        this.personalPhonePassword = personalPhonePassword == null ? null : personalPhonePassword.trim();
    }

    public String getPersonalPlaceofdomicile() {
        return personalPlaceofdomicile;
    }

    public void setPersonalPlaceofdomicile(String personalPlaceofdomicile) {
        this.personalPlaceofdomicile = personalPlaceofdomicile == null ? null : personalPlaceofdomicile.trim();
    }

    public String getPersonalLivingCondition() {
        return personalLivingCondition;
    }

    public void setPersonalLivingCondition(String personalLivingCondition) {
        this.personalLivingCondition = personalLivingCondition == null ? null : personalLivingCondition.trim();
    }

    public String getPersonalLivingConditionOther() {
        return personalLivingConditionOther;
    }

    public void setPersonalLivingConditionOther(String personalLivingConditionOther) {
        this.personalLivingConditionOther = personalLivingConditionOther == null ? null : personalLivingConditionOther.trim();
    }

    public String getPersonalLivingProvinceName() {
        return personalLivingProvinceName;
    }

    public void setPersonalLivingProvinceName(String personalLivingProvinceName) {
        this.personalLivingProvinceName = personalLivingProvinceName == null ? null : personalLivingProvinceName.trim();
    }

    public String getPersonalLivingProvinceCode() {
        return personalLivingProvinceCode;
    }

    public void setPersonalLivingProvinceCode(String personalLivingProvinceCode) {
        this.personalLivingProvinceCode = personalLivingProvinceCode == null ? null : personalLivingProvinceCode.trim();
    }

    public String getPersonalLivingCityName() {
        return personalLivingCityName;
    }

    public void setPersonalLivingCityName(String personalLivingCityName) {
        this.personalLivingCityName = personalLivingCityName == null ? null : personalLivingCityName.trim();
    }

    public String getPersonalLivingCityCode() {
        return personalLivingCityCode;
    }

    public void setPersonalLivingCityCode(String personalLivingCityCode) {
        this.personalLivingCityCode = personalLivingCityCode == null ? null : personalLivingCityCode.trim();
    }

    public String getPersonalLivingAreaName() {
        return personalLivingAreaName;
    }

    public void setPersonalLivingAreaName(String personalLivingAreaName) {
        this.personalLivingAreaName = personalLivingAreaName == null ? null : personalLivingAreaName.trim();
    }

    public String getPersonalLivingAreaCode() {
        return personalLivingAreaCode;
    }

    public void setPersonalLivingAreaCode(String personalLivingAreaCode) {
        this.personalLivingAreaCode = personalLivingAreaCode == null ? null : personalLivingAreaCode.trim();
    }

    public String getPersonalLivingAddress() {
        return personalLivingAddress;
    }

    public void setPersonalLivingAddress(String personalLivingAddress) {
        this.personalLivingAddress = personalLivingAddress == null ? null : personalLivingAddress.trim();
    }

    public String getPersonalNoneCorp() {
        return personalNoneCorp;
    }

    public void setPersonalNoneCorp(String personalNoneCorp) {
        this.personalNoneCorp = personalNoneCorp == null ? null : personalNoneCorp.trim();
    }

    public String getPersonalNickname() {
        return personalNickname;
    }

    public void setPersonalNickname(String personalNickname) {
        this.personalNickname = personalNickname == null ? null : personalNickname.trim();
    }

    public String getPersonalUsername() {
        return personalUsername;
    }

    public void setPersonalUsername(String personalUsername) {
        this.personalUsername = personalUsername == null ? null : personalUsername.trim();
    }

    public Date getPersonalCreatTime() {
        return personalCreatTime;
    }

    public void setPersonalCreatTime(Date personalCreatTime) {
        this.personalCreatTime = personalCreatTime;
    }

    public Date getPersonalUpdateTime() {
        return personalUpdateTime;
    }

    public void setPersonalUpdateTime(Date personalUpdateTime) {
        this.personalUpdateTime = personalUpdateTime;
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }
}