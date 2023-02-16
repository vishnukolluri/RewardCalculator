package com.rewards.rewardcalculater.model;

import lombok.Data;

@Data
public class Rewards {
    private long customerId;
	private long lastMonthRewards;
    private long lastSecondMonthRewards;
    private long lastThirdMonthRewards;
    private long totalRewards;
	
   
}
