package com.sps.entity.user;

import java.io.Serializable;
import java.util.Date;

public class SpsRole implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer roleId;

    private String roleName;

    private String roleDescribe;

    private String roleCreater;

    private Integer roleMark;

    private Date roleCreattime;

    private Date roleUpdatetime;

    private Integer roleState;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    public String getRoleCreater() {
        return roleCreater;
    }

    public void setRoleCreater(String roleCreater) {
        this.roleCreater = roleCreater == null ? null : roleCreater.trim();
    }

    public Integer getRoleMark() {
        return roleMark;
    }

    public void setRoleMark(Integer roleMark) {
        this.roleMark = roleMark;
    }

    public Date getRoleCreattime() {
        return roleCreattime;
    }

    public void setRoleCreattime(Date roleCreattime) {
        this.roleCreattime = roleCreattime;
    }

    public Date getRoleUpdatetime() {
        return roleUpdatetime;
    }

    public void setRoleUpdatetime(Date roleUpdatetime) {
        this.roleUpdatetime = roleUpdatetime;
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }
}