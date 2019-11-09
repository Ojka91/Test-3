package com.ssiconcatel.test3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssiconcatel.test3.controller.RestController;
import com.ssiconcatel.test3.service.Service;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.xml.ws.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class Test3ApplicationTests {

	@Mock
	private Service service;
	@InjectMocks
	private RestController restController;

	private MockMvc mockMvc;
	private ObjectMapper om = new ObjectMapper();

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	void testApiTest() {
		String result = restController.testApi();
		String expected = "Api OK";
		assertEquals(expected, result);
	}

	@Test
	public void testApiTest2() throws Exception{
		when(service.testApi()).thenReturn("Api OK");
		mockMvc.perform(
				get("/api")
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Api OK"));
		verify(restController).testApi();
	}

	@Test
	void testAddRebelManual(){

	}

	@Test
	void testAddRebel() throws Exception{
		String json = "{\n"+
				"	\"name\": \"Alien\",\n"+
				"	\"planet\": \"wow\" \n"+
				"}";
		mockMvc.perform(post("/api/addRebel")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				)
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string("true"));
	}

	@Test
	void testAddRebel2() throws  Exception{
		Rebel rebel = new Rebel("alien", "sun");
		String jsonRequest = om.writeValueAsString(rebel);
		MvcResult result = mockMvc.perform(post("/addRebel").content(jsonRequest)
				.content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);

		Assert.assertTrue(response.isDone() == Boolean.TRUE);
	}


	@Test
	void testAddRebelInfoList() throws Exception {

		MvcResult result = mockMvc
				.perform(get("/getRebelInfo")
				.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		String resultContent= result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isDone() == Boolean.TRUE);
	}

}
