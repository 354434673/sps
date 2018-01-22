package com.sps.entity.merchant;

import java.io.Serializable;
import java.util.Date;

public class SpsChannelPic implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer picId;

    private String picSrc;

    private Integer picType;

    private Date picUploadTime;

    private String picOldName;

    private String picNewName;

    private Integer picState;

    private String channelNum;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public Date getPicUploadTime() {
        return picUploadTime;
    }

    public void setPicUploadTime(Date picUploadTime) {
        this.picUploadTime = picUploadTime;
    }

    public String getPicOldName() {
        return picOldName;
    }

    public void setPicOldName(String picOldName) {
        this.picOldName = picOldName == null ? null : picOldName.trim();
    }

    public String getPicNewName() {
        return picNewName;
    }

    public void setPicNewName(String picNewName) {
        this.picNewName = picNewName == null ? null : picNewName.trim();
    }

    public Integer getPicState() {
        return picState;
    }

    public void setPicState(Integer picState) {
        this.picState = picState;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}