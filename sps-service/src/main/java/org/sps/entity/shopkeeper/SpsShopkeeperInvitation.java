package org.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperInvitation implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer invitationId;

    private String invitationName;

    private String invitationPhone;

    private Date invitationTime;

    private String invitationState;

    private Date invitationCreatTime;

    private Date invitationUpdateTime;

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public String getInvitationName() {
        return invitationName;
    }

    public void setInvitationName(String invitationName) {
        this.invitationName = invitationName == null ? null : invitationName.trim();
    }

    public String getInvitationPhone() {
        return invitationPhone;
    }

    public void setInvitationPhone(String invitationPhone) {
        this.invitationPhone = invitationPhone == null ? null : invitationPhone.trim();
    }

    public Date getInvitationTime() {
        return invitationTime;
    }

    public void setInvitationTime(Date invitationTime) {
        this.invitationTime = invitationTime;
    }

    public String getInvitationState() {
        return invitationState;
    }

    public void setInvitationState(String invitationState) {
        this.invitationState = invitationState == null ? null : invitationState.trim();
    }

    public Date getInvitationCreatTime() {
        return invitationCreatTime;
    }

    public void setInvitationCreatTime(Date invitationCreatTime) {
        this.invitationCreatTime = invitationCreatTime;
    }

    public Date getInvitationUpdateTime() {
        return invitationUpdateTime;
    }

    public void setInvitationUpdateTime(Date invitationUpdateTime) {
        this.invitationUpdateTime = invitationUpdateTime;
    }
}