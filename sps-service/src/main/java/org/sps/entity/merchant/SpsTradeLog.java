package org.sps.entity.merchant;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018-03-31.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public class SpsTradeLog implements Serializable {
    //主键
    private Integer logId;
    //登录用户名
    private String logName;
    //操作方式
    private Integer logType;
    //详细描述
    private String logDes;
    //创建时间
    private Date logCreateTime;
    //更新时间
    private Date logUpdateTime;

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
        this.logName = logName;
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
        this.logDes = logDes;
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
