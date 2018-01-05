package com.sps.controller.areas;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.entity.areas.Areas;
import com.sps.service.user.AreasService;

@Controller
public class AreasController {
	@Resource
	private AreasService areasService;
	@RequestMapping("/getAreasList.json")
	public @ResponseBody List<Areas> getAreas(String parentId){
		
		List<Areas> areasList = areasService.getAreasList(parentId);
		
		return areasList;
	}
}
