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
	
    private Integer id;

    private String title;

    private Integer menuNodetype;

    private String href;

    private Integer menuParentid;

    private List<MenuUtil> children;

    	
	public MenuUtil() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuUtil(Integer id, String title, Integer menuNodetype, String href, Integer menuParentid,
			List<MenuUtil> children) {
		super();
		this.id = id;
		this.title = title;
		this.menuNodetype = menuNodetype;
		this.href = href;
		this.menuParentid = menuParentid;
		this.children = children;
	}


	@Override
	public String toString() {
		return "MenuUtil [id=" + id + ", title=" + title + ", menuNodetype=" + menuNodetype + ", href=" + href
				+ ", menuParentid=" + menuParentid + ", children=" + children + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getMenuNodetype() {
		return menuNodetype;
	}


	public void setMenuNodetype(Integer menuNodetype) {
		this.menuNodetype = menuNodetype;
	}


	public String getHref() {
		return href;
	}


	public void setHref(String href) {
		this.href = href;
	}


	public Integer getMenuParentid() {
		return menuParentid;
	}


	public void setMenuParentid(Integer menuParentid) {
		this.menuParentid = menuParentid;
	}


	public List<MenuUtil> getChildren() {
		return children;
	}


	public void setChildren(List<MenuUtil> children) {
		this.children = children;
	}
	
}
