package com.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;

public class SpsGoodsAlbum implements Serializable {
    private Integer albumId;

    private Integer goodsId;

    private String albumUrl;

    private Integer albumType;

    private Integer albumDeleteFlag;

    private Date albumCreateTime;

    private Date albumUpdateTime;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl == null ? null : albumUrl.trim();
    }

    public Integer getAlbumType() {
        return albumType;
    }

    public void setAlbumType(Integer albumType) {
        this.albumType = albumType;
    }

    public Integer getAlbumDeleteFlag() {
        return albumDeleteFlag;
    }

    public void setAlbumDeleteFlag(Integer albumDeleteFlag) {
        this.albumDeleteFlag = albumDeleteFlag;
    }

    public Date getAlbumCreateTime() {
        return albumCreateTime;
    }

    public void setAlbumCreateTime(Date albumCreateTime) {
        this.albumCreateTime = albumCreateTime;
    }

    public Date getAlbumUpdateTime() {
        return albumUpdateTime;
    }

    public void setAlbumUpdateTime(Date albumUpdateTime) {
        this.albumUpdateTime = albumUpdateTime;
    }
}