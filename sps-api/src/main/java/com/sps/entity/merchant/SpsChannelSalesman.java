package com.sps.entity.merchant;

import java.io.Serializable;

public class SpsChannelSalesman implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer salesmanId;

    private String salesmanName;

    private String salesmanIdcard;

    private String salesmanPhone;

    private String salesmanEmail;

    private String salesmanCity;

    private String bei1;

    private String bei2;

    private String bei3;

    private String bei4;

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName == null ? null : salesmanName.trim();
    }

    public String getSalesmanIdcard() {
        return salesmanIdcard;
    }

    public void setSalesmanIdcard(String salesmanIdcard) {
        this.salesmanIdcard = salesmanIdcard == null ? null : salesmanIdcard.trim();
    }

    public String getSalesmanPhone() {
        return salesmanPhone;
    }

    public void setSalesmanPhone(String salesmanPhone) {
        this.salesmanPhone = salesmanPhone == null ? null : salesmanPhone.trim();
    }

    public String getSalesmanEmail() {
        return salesmanEmail;
    }

    public void setSalesmanEmail(String salesmanEmail) {
        this.salesmanEmail = salesmanEmail == null ? null : salesmanEmail.trim();
    }

    public String getSalesmanCity() {
        return salesmanCity;
    }

    public void setSalesmanCity(String salesmanCity) {
        this.salesmanCity = salesmanCity == null ? null : salesmanCity.trim();
    }

    public String getBei1() {
        return bei1;
    }

    public void setBei1(String bei1) {
        this.bei1 = bei1 == null ? null : bei1.trim();
    }

    public String getBei2() {
        return bei2;
    }

    public void setBei2(String bei2) {
        this.bei2 = bei2 == null ? null : bei2.trim();
    }

    public String getBei3() {
        return bei3;
    }

    public void setBei3(String bei3) {
        this.bei3 = bei3 == null ? null : bei3.trim();
    }

    public String getBei4() {
        return bei4;
    }

    public void setBei4(String bei4) {
        this.bei4 = bei4 == null ? null : bei4.trim();
    }
}