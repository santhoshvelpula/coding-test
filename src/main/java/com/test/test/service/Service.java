package com.test.test.service;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@org.springframework.stereotype.Service
public class Service {

	org.slf4j.Logger logger = LoggerFactory.getLogger(Service.class);

	public Map<String, List<String>> getAllBreads() {

		Map<String, List<String>> breeds = new HashMap<String, List<String>>();

		try {
			FileInputStream fin = new  FileInputStream("sample.json");
			breeds = new ObjectMapper().readValue(fin, HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while parsing json:: {}", e.getCause());
		}

		return breeds;

	}

}
