package com.sps.entity.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SpsMenu implements Serializable{
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer menuId;

    private String menuName;

    private Integer menuNodetype;

    private String menuUrl;

    private Integer menuParentid;

    private Integer menuState;

    private Integer menuSort;

    private Integer menuMark;

    private String menuCreater;

    private Date menuCreattime;

    private Date menuUpdatetime;
    
    private List<SpsRoleandmenu> role;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuNodetype() {
        return menuNodetype;
    }

    public void setMenuNodetype(Integer menuNodetype) {
        this.menuNodetype = menuNodetype;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMenuParentid() {
        return menuParentid;
    }

    public void setMenuParentid(Integer menuParentid) {
        this.menuParentid = menuParentid;
    }

    public Integer getMenuState() {
        return menuState;
    }

    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public Integer getMenuMark() {
        return menuMark;
    }

    public void setMenuMark(Integer menuMark) {
        this.menuMark = menuMark;
    }

    public String getMenuCreater() {
        return menuCreater;
    }

    public void setMenuCreater(String menuCreater) {
        this.menuCreater = menuCreater == null ? null : menuCreater.trim();
    }

    public Date getMenuCreattime() {
        return menuCreattime;
    }

    public void setMenuCreattime(Date menuCreattime) {
        this.menuCreattime = menuCreattime;
    }

    public Date getMenuUpdatetime() {
        return menuUpdatetime;
    }

    public void setMenuUpdatetime(Date menuUpdatetime) {
        this.menuUpdatetime = menuUpdatetime;
    }

	public List<SpsRoleandmenu> getRole() {
		return role;
	}

	public void setRole(List<SpsRoleandmenu> role) {
		this.role = role;
	}
    
}