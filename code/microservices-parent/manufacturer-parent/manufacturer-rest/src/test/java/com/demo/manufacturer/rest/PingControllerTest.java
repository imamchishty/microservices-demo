package com.demo.manufacturer.rest;

import com.demo.manufacturer.rest.constant.ApiConstants;
import com.demo.manufacturer.rest.controller.PingController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class PingControllerTest {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		PingController controller = new PingController();
		controller.setAppName("manufacturer-rest");
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void checkPing() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(ApiConstants.API_PING).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("manufacturer-rest is running.....")));
	}
}
