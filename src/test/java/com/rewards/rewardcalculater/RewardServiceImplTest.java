package com.rewards.rewardcalculater;

import com.rewards.rewardcalculater.entity.Transaction;
import com.rewards.rewardcalculater.model.Rewards;
import com.rewards.rewardcalculater.service.RewardServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RewardServiceImplTest {

	@Mock
	private RewardServiceImpl rewardServiceImpl;


	
	@Test
	public void test_getPointsByCustomerId()
	{
		Rewards	rewards=new Rewards (); 
		rewards.setCustomerId(1l);
		rewards.setLastMonthRewards(123); 
		rewards.setLastSecondMonthRewards(0);
		rewards.setLastThirdMonthRewards(0); 
		rewards.setTotalRewards(0);

		Mockito.when(rewardServiceImpl.getPointsByCustomerId(1l)).thenReturn(rewards);
		Rewards reward=rewardServiceImpl.getPointsByCustomerId(1l);
		assertEquals(1l, reward.getCustomerId()); 		
		assertEquals(123, reward.getLastMonthRewards()); 		

	}
	
	@Test
	public void test_calculatePoints()
	{
		Transaction	transaction=new Transaction (); 
		transaction.setCustomerId(1l);
		transaction.setTransactionAmount(120);
		transaction.setTransactionId(1l);
		transaction.setTransactionDate(Timestamp.valueOf("2022-08-09 00:00:00")); 
		
		Mockito.when(rewardServiceImpl.calculatePoints(transaction)).thenReturn(1l);
		long points=rewardServiceImpl.calculatePoints(transaction);
		assertEquals(1l, points); 		


	}

}
