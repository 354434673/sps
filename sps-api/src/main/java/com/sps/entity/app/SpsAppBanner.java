package com.sps.entity.app;

import java.io.Serializable;
import java.util.Date;

public class SpsAppBanner implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer bId;

    private String bName;

    private String bPath;

    private Date bCreatetime;

    private Integer bIndex;

    private Date bCarouseltime;

    private Integer bSecond;

    private String bRemark;

    private Integer bIsuse;

    private String bLinkaddress;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbPath() {
        return bPath;
    }

    public void setbPath(String bPath) {
        this.bPath = bPath == null ? null : bPath.trim();
    }

    public Date getbCreatetime() {
        return bCreatetime;
    }

    public void setbCreatetime(Date bCreatetime) {
        this.bCreatetime = bCreatetime;
    }

    public Integer getbIndex() {
        return bIndex;
    }

    public void setbIndex(Integer bIndex) {
        this.bIndex = bIndex;
    }

    public Date getbCarouseltime() {
        return bCarouseltime;
    }

    public void setbCarouseltime(Date bCarouseltime) {
        this.bCarouseltime = bCarouseltime;
    }

    public Integer getbSecond() {
        return bSecond;
    }

    public void setbSecond(Integer bSecond) {
        this.bSecond = bSecond;
    }

    public String getbRemark() {
        return bRemark;
    }

    public void setbRemark(String bRemark) {
        this.bRemark = bRemark == null ? null : bRemark.trim();
    }

    public Integer getbIsuse() {
        return bIsuse;
    }

    public void setbIsuse(Integer bIsuse) {
        this.bIsuse = bIsuse;
    }

    public String getbLinkaddress() {
        return bLinkaddress;
    }

    public void setbLinkaddress(String bLinkaddress) {
        this.bLinkaddress = bLinkaddress == null ? null : bLinkaddress.trim();
    }
}