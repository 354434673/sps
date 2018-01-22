package com.sps.common;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	
	private int current = 1; // 当前页码
	private int pagesize = 10; // 页面大小
	private int toatl;// 总记录数
	private int start;// 记录开始下标
	private List<T> list = new ArrayList<T>();

	public Page() {
	}

	public Page(int current, int pagesize) {
		this.current = current;
		this.pagesize = pagesize;
	}

	public void setStart(int start){
		this.start = start;
	}

	public int getStart(){
		int c = this.current;
		if (c<=0){
			c = 1;
		}
		start = (c - 1) * this.pagesize;
		return start;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getToatl() {
		return toatl;
	}

	public void setToatl(int toatl) {
		this.toatl = toatl;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
