package com.test.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.test.controller.RestController;
import com.test.test.model.MyResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private RestController controller;

	@org.junit.Test
	public void getAllBreads() throws Exception {

		MyResponse response = this.restTemplate.getForObject("http://localhost:" + port + "/breeds/list/all",
				MyResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getMessage());
		Assert.assertNotNull(response);
		List<String> list = new ArrayList<>();
		list.add("staffordshire");
		Assert.assertEquals("Checking Breed terrier", response.getMessage().get("bullterrier"), list);

	}

}
