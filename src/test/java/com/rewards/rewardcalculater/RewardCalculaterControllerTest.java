package com.rewards.rewardcalculater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewards.rewardcalculater.model.Rewards;
import com.rewards.rewardcalculater.service.RewardServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RewardCalculaterControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Mock
	private RewardServiceImpl rewardServiceImpl;

	@Mock
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	@Test
	public void testEmployee() throws Exception {
		rewardServiceImpl.getPointsByCustomerId(1002l);
		mockMvc.perform(get("/getRewards/1002")).andExpect(status().isOk())
		.andExpect(jsonPath("$.customerId").value("1002"));

	}
	@Test 
	public void test_getPointsByCustomerId_success() throws Exception {
		Rewards	rewards=new Rewards (); 
		rewards.setCustomerId(1l);
		rewards.setLastMonthRewards(123); 
		rewards.setLastSecondMonthRewards(0);
		rewards.setLastThirdMonthRewards(0); 
		rewards.setTotalRewards(0);

		Mockito.when(rewardServiceImpl.getPointsByCustomerId(1l)).thenReturn(rewards);


		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/getRewards/1001")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		int status =mvcResult.getResponse().getStatus();
		assertEquals(200, status); 		

	}
	@Test 
	public void test_getPointsByCustomerId() throws Exception {
		Rewards	rewards=new Rewards (); 
		rewards.setCustomerId(1l);
		rewards.setLastMonthRewards(123); 
		rewards.setLastSecondMonthRewards(0);
		rewards.setLastThirdMonthRewards(0); 
		rewards.setTotalRewards(0);

		Mockito.when(rewardServiceImpl.getPointsByCustomerId(5l)).thenReturn(rewards);


		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/getRewards/1002")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		String status =mvcResult.getResponse().getContentAsString();
		assertNotNull(status); 		

	}

}
