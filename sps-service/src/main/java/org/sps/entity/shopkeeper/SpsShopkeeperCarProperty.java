package org.sps.entity.shopkeeper;

import java.util.Date;

public class SpsShopkeeperCarProperty {
    private Integer carId;

    private Integer carIsHave;

    private String carChassisNum;

    private String carPlateNum;

    private String carBrand;

    private String shopkeeperCustomerid;

    private String carUsername;

    private Date carCreatTime;

    private Date carUpdateTime;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarIsHave() {
        return carIsHave;
    }

    public void setCarIsHave(Integer carIsHave) {
        this.carIsHave = carIsHave;
    }

    public String getCarChassisNum() {
        return carChassisNum;
    }

    public void setCarChassisNum(String carChassisNum) {
        this.carChassisNum = carChassisNum == null ? null : carChassisNum.trim();
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum == null ? null : carPlateNum.trim();
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getCarUsername() {
        return carUsername;
    }

    public void setCarUsername(String carUsername) {
        this.carUsername = carUsername == null ? null : carUsername.trim();
    }

    public Date getCarCreatTime() {
        return carCreatTime;
    }

    public void setCarCreatTime(Date carCreatTime) {
        this.carCreatTime = carCreatTime;
    }

    public Date getCarUpdateTime() {
        return carUpdateTime;
    }

    public void setCarUpdateTime(Date carUpdateTime) {
        this.carUpdateTime = carUpdateTime;
    }
}