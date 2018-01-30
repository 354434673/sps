package org.sps.entity.shopkeeper;

import java.math.BigDecimal;
import java.util.Date;

public class SpsShopkeeperTaking {
    private Integer takingId;

    private BigDecimal takingMonthAvgTurnover;

    private String shopkeeperCustomerid;

    private String takingUsername;

    private Date takingCreatTime;

    private Date takingUpdateTime;

    public Integer getTakingId() {
        return takingId;
    }

    public void setTakingId(Integer takingId) {
        this.takingId = takingId;
    }

    public BigDecimal getTakingMonthAvgTurnover() {
        return takingMonthAvgTurnover;
    }

    public void setTakingMonthAvgTurnover(BigDecimal takingMonthAvgTurnover) {
        this.takingMonthAvgTurnover = takingMonthAvgTurnover;
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getTakingUsername() {
        return takingUsername;
    }

    public void setTakingUsername(String takingUsername) {
        this.takingUsername = takingUsername == null ? null : takingUsername.trim();
    }

    public Date getTakingCreatTime() {
        return takingCreatTime;
    }

    public void setTakingCreatTime(Date takingCreatTime) {
        this.takingCreatTime = takingCreatTime;
    }

    public Date getTakingUpdateTime() {
        return takingUpdateTime;
    }

    public void setTakingUpdateTime(Date takingUpdateTime) {
        this.takingUpdateTime = takingUpdateTime;
    }
}