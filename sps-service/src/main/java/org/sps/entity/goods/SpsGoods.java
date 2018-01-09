package org.sps.entity.goods;

import java.io.Serializable;
import java.util.Date;

public class SpsGoods  implements Serializable {
    private Integer gId;

    private String gCategoryNames;

    private String brandName;

    private String gCategoryIds;

    private Integer gBrandId;

    private String gSpuName;

    private String gSpuNo;

    private String gUnit;

    private String gPic;

    private String gDpic;

    private Integer gDeleteFlag;

    private Date gCreateTime;

    private Date gUpdateTime;

    private String gDetails;

    private String gRemark;


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getgDetails() {
        return gDetails;
    }

    public void setgDetails(String gDetails) {
        this.gDetails = gDetails == null ? null : gDetails.trim();
    }

    public String getgRemark() {
        return gRemark;
    }

    public void setgRemark(String gRemark) {
        this.gRemark = gRemark == null ? null : gRemark.trim();
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgCategoryNames() {
        return gCategoryNames;
    }

    public void setgCategoryNames(String gCategoryNames) {
        this.gCategoryNames = gCategoryNames == null ? null : gCategoryNames.trim();
    }

    public String getgCategoryIds() {
        return gCategoryIds;
    }

    public void setgCategoryIds(String gCategoryIds) {
        this.gCategoryIds = gCategoryIds == null ? null : gCategoryIds.trim();
    }

    public Integer getgBrandId() {
        return gBrandId;
    }

    public void setgBrandId(Integer gBrandId) {
        this.gBrandId = gBrandId;
    }

    public String getgSpuName() {
        return gSpuName;
    }

    public void setgSpuName(String gSpuName) {
        this.gSpuName = gSpuName == null ? null : gSpuName.trim();
    }

    public String getgSpuNo() {
        return gSpuNo;
    }

    public void setgSpuNo(String gSpuNo) {
        this.gSpuNo = gSpuNo == null ? null : gSpuNo.trim();
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit == null ? null : gUnit.trim();
    }

    public String getgPic() {
        return gPic;
    }

    public void setgPic(String gPic) {
        this.gPic = gPic == null ? null : gPic.trim();
    }

    public String getgDpic() {
        return gDpic;
    }

    public void setgDpic(String gDpic) {
        this.gDpic = gDpic == null ? null : gDpic.trim();
    }

    public Integer getgDeleteFlag() {
        return gDeleteFlag;
    }

    public void setgDeleteFlag(Integer gDeleteFlag) {
        this.gDeleteFlag = gDeleteFlag;
    }

    public Date getgCreateTime() {
        return gCreateTime;
    }

    public void setgCreateTime(Date gCreateTime) {
        this.gCreateTime = gCreateTime;
    }

    public Date getgUpdateTime() {
        return gUpdateTime;
    }

    public void setgUpdateTime(Date gUpdateTime) {
        this.gUpdateTime = gUpdateTime;
    }
}