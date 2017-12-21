package com.sps.util;

import java.util.List;

/**
 * 该类用于将菜单转为特定的json格式
 * @ClassName:  MenuUtil   
 * @Deurlion:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2017年12月22日 下午2:36:01
 */
public class MenuUtil {
	
    private Integer menuId;

    private String name;

    private Integer menuNodetype;

    private String script;

    private Integer menuParentid;

    private List<MenuUtil> subMenu;

    	
	public MenuUtil() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuUtil(Integer menuId, String name, Integer menuNodetype, String script, Integer menuParentid,
			List<MenuUtil> subMenu) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.menuNodetype = menuNodetype;
		this.script = script;
		this.menuParentid = menuParentid;
		this.subMenu = subMenu;
	}


	@Override
	public String toString() {
		return "MenuUtil [menuId=" + menuId + ", name=" + name + ", menuNodetype=" + menuNodetype + ", script=" + script
				+ ", menuParentid=" + menuParentid + ", subMenu=" + subMenu + "]";
	}


	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getMenuNodetype() {
		return menuNodetype;
	}


	public void setMenuNodetype(Integer menuNodetype) {
		this.menuNodetype = menuNodetype;
	}


	public String getScript() {
		return script;
	}


	public void setScript(String script) {
		this.script = script;
	}


	public Integer getMenuParentid() {
		return menuParentid;
	}


	public void setMenuParentid(Integer menuParentid) {
		this.menuParentid = menuParentid;
	}


	public List<MenuUtil> getSubMenu() {
		return subMenu;
	}


	public void setSubMenu(List<MenuUtil> subMenu) {
		this.subMenu = subMenu;
	}
	
	
	
    
}
