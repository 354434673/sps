package org.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperHouseProperty implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer houseId;

    private Integer houseIsHave;

    private Double houseArea;

    private String houseAddr;

    private String shopkeeperCustomerid;

    private String houseUsername;

    private Date houseCreatTime;

    private Date houseUpdateTime;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseIsHave() {
        return houseIsHave;
    }

    public void setHouseIsHave(Integer houseIsHave) {
        this.houseIsHave = houseIsHave;
    }

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr == null ? null : houseAddr.trim();
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getHouseUsername() {
        return houseUsername;
    }

    public void setHouseUsername(String houseUsername) {
        this.houseUsername = houseUsername == null ? null : houseUsername.trim();
    }

    public Date getHouseCreatTime() {
        return houseCreatTime;
    }

    public void setHouseCreatTime(Date houseCreatTime) {
        this.houseCreatTime = houseCreatTime;
    }

    public Date getHouseUpdateTime() {
        return houseUpdateTime;
    }

    public void setHouseUpdateTime(Date houseUpdateTime) {
        this.houseUpdateTime = houseUpdateTime;
    }
}