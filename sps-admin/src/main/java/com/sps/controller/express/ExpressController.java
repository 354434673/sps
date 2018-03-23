package com.sps.controller.express;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.service.express.ExpressService;


@Controller
@RequestMapping("/express")
public class ExpressController {
	@Resource
	private ExpressService expressService;
	@RequestMapping("/getExpressList.json")
	@ResponseBody
	public HashMap<String, Object> getExpressList(String name, Integer page, Integer limit){
		
		HashMap<String, Object> express = expressService.getExpress(name, page, limit);
		
		return express;
	};
}
