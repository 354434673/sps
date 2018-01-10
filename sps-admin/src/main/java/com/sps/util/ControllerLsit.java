package com.sps.util;

import java.util.List;

import org.sps.entity.merchant.SpsChannelGather;

public class ControllerLsit {
	
	private List<SpsChannelGather> gathers;

	public List<SpsChannelGather> getGathers() {
		return gathers;
	}
	public void setGathers(List<SpsChannelGather> gathers) {
		this.gathers = gathers;
	}
	public ControllerLsit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ControllerLsit(List<SpsChannelGather> gathers) {
		super();
		this.gathers = gathers;
	}
	
	
}	
