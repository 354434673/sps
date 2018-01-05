package org.sps.entity.merchant;

public class SpsChannelGather {
    private Integer gatherId;

    private String gatherBankId;

    private String gatherOwnerName;

    private String gatherIdcard;

    private String gatherPhone;

    private String gatherDepositBank;

    private String gatherBankBranch;

    private String gatherBankSubbranch;

    private String channelNum;

    public Integer getGatherId() {
        return gatherId;
    }

    public void setGatherId(Integer gatherId) {
        this.gatherId = gatherId;
    }

    public String getGatherBankId() {
        return gatherBankId;
    }

    public void setGatherBankId(String gatherBankId) {
        this.gatherBankId = gatherBankId == null ? null : gatherBankId.trim();
    }

    public String getGatherOwnerName() {
        return gatherOwnerName;
    }

    public void setGatherOwnerName(String gatherOwnerName) {
        this.gatherOwnerName = gatherOwnerName == null ? null : gatherOwnerName.trim();
    }

    public String getGatherIdcard() {
        return gatherIdcard;
    }

    public void setGatherIdcard(String gatherIdcard) {
        this.gatherIdcard = gatherIdcard == null ? null : gatherIdcard.trim();
    }

    public String getGatherPhone() {
        return gatherPhone;
    }

    public void setGatherPhone(String gatherPhone) {
        this.gatherPhone = gatherPhone == null ? null : gatherPhone.trim();
    }

    public String getGatherDepositBank() {
        return gatherDepositBank;
    }

    public void setGatherDepositBank(String gatherDepositBank) {
        this.gatherDepositBank = gatherDepositBank == null ? null : gatherDepositBank.trim();
    }

    public String getGatherBankBranch() {
        return gatherBankBranch;
    }

    public void setGatherBankBranch(String gatherBankBranch) {
        this.gatherBankBranch = gatherBankBranch == null ? null : gatherBankBranch.trim();
    }

    public String getGatherBankSubbranch() {
        return gatherBankSubbranch;
    }

    public void setGatherBankSubbranch(String gatherBankSubbranch) {
        this.gatherBankSubbranch = gatherBankSubbranch == null ? null : gatherBankSubbranch.trim();
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}