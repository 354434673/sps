package org.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;

public class SpsCustomCategory  implements Serializable {
    private Integer customId;

    private String customName;

    private String customWide;

    private Integer customDeleteFlag;

    private Date customCreateTime;

    private Date customUpdateTime;

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getCustomWide() {
        return customWide;
    }

    public void setCustomWide(String customWide) {
        this.customWide = customWide == null ? null : customWide.trim();
    }

    public Integer getCustomDeleteFlag() {
        return customDeleteFlag;
    }

    public void setCustomDeleteFlag(Integer customDeleteFlag) {
        this.customDeleteFlag = customDeleteFlag;
    }

    public Date getCustomCreateTime() {
        return customCreateTime;
    }

    public void setCustomCreateTime(Date customCreateTime) {
        this.customCreateTime = customCreateTime;
    }

    public Date getCustomUpdateTime() {
        return customUpdateTime;
    }

    public void setCustomUpdateTime(Date customUpdateTime) {
        this.customUpdateTime = customUpdateTime;
    }
}