package com.test.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.test.model.MyResponse;
import com.test.test.service.Service;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private Service service;
	
	@GetMapping("breeds/list/all")
	public MyResponse getAllBreads(){
		
		
		Map<String, List<String>> breads = service.getAllBreads();
		
		MyResponse response = new MyResponse();
		response.setMessage(breads);
		response.setStatus("success");
		
		
		return response;
		
	}

}
