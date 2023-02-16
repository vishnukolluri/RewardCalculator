package com.rewards.rewardcalculater.service;

import com.rewards.rewardcalculater.model.Rewards;


public interface RewardService {

	public Rewards getPointsByCustomerId(Long customerId);

}
