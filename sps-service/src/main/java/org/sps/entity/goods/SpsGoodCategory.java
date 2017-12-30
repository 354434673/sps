package org.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SpsGoodCategory implements Serializable {
    private Integer id;

    private String name;

    private Integer categoryId;

    private String categoryName;

    private Integer categoryParentId;

    private Integer categoryWeight;

    private String categoryDes;

    private String categoryUrl;

    private Integer categoryDeleteFlag;

    private Date categoryCreateTime;

    private Date categoryUpdateTime;

    private List<SpsGoodCategory> children;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public Integer getCategoryWeight() {
        return categoryWeight;
    }

    public void setCategoryWeight(Integer categoryWeight) {
        this.categoryWeight = categoryWeight;
    }

    public String getCategoryDes() {
        return categoryDes;
    }

    public void setCategoryDes(String categoryDes) {
        this.categoryDes = categoryDes == null ? null : categoryDes.trim();
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
    }

    public Integer getCategoryDeleteFlag() {
        return categoryDeleteFlag;
    }

    public void setCategoryDeleteFlag(Integer categoryDeleteFlag) {
        this.categoryDeleteFlag = categoryDeleteFlag;
    }

    public Date getCategoryCreateTime() {
        return categoryCreateTime;
    }

    public void setCategoryCreateTime(Date categoryCreateTime) {
        this.categoryCreateTime = categoryCreateTime;
    }

    public Date getCategoryUpdateTime() {
        return categoryUpdateTime;
    }

    public void setCategoryUpdateTime(Date categoryUpdateTime) {
        this.categoryUpdateTime = categoryUpdateTime;
    }


    public List<SpsGoodCategory> getChildren() {
        return children;
    }

    public void setChildren(List<SpsGoodCategory> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}