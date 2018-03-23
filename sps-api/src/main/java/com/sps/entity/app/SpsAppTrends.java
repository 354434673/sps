package com.sps.entity.app;

import java.io.Serializable;
import java.util.Date;

public class SpsAppTrends implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tId;

    private String tTitle;

    private Date tCreatetime;

    private String tContent;

    private String tImg;

    private String tRemark;

    private String tBak;

    private Integer tIsuse;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle == null ? null : tTitle.trim();
    }

    public Date gettCreatetime() {
        return tCreatetime;
    }

    public void settCreatetime(Date tCreatetime) {
        this.tCreatetime = tCreatetime;
    }

    public String gettContent() {
        return tContent;
    }

    public void settContent(String tContent) {
        this.tContent = tContent == null ? null : tContent.trim();
    }

    public String gettImg() {
        return tImg;
    }

    public void settImg(String tImg) {
        this.tImg = tImg == null ? null : tImg.trim();
    }

    public String gettRemark() {
        return tRemark;
    }

    public void settRemark(String tRemark) {
        this.tRemark = tRemark == null ? null : tRemark.trim();
    }

    public String gettBak() {
        return tBak;
    }

    public void settBak(String tBak) {
        this.tBak = tBak == null ? null : tBak.trim();
    }

    public Integer gettIsuse() {
        return tIsuse;
    }

    public void settIsuse(Integer tIsuse) {
        this.tIsuse = tIsuse;
    }
}