package com.sps.entity.order;

import java.io.Serializable;
import java.util.Date;

public class SpsOrderLog implements Serializable {
    private Integer logId;

    private String logName;

    private Integer logType;

    private String logDes;
    private String logOrderNo;

    private Date logCreateTime;

    private Date logUpdateTime;


    public String getLogOrderNo() {
        return logOrderNo;
    }

    public void setLogOrderNo(String logOrderNo) {
        this.logOrderNo = logOrderNo;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLogDes() {
        return logDes;
    }

    public void setLogDes(String logDes) {
        this.logDes = logDes == null ? null : logDes.trim();
    }

    public Date getLogCreateTime() {
        return logCreateTime;
    }

    public void setLogCreateTime(Date logCreateTime) {
        this.logCreateTime = logCreateTime;
    }

    public Date getLogUpdateTime() {
        return logUpdateTime;
    }

    public void setLogUpdateTime(Date logUpdateTime) {
        this.logUpdateTime = logUpdateTime;
    }
}