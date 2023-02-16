package com.rewards.rewardcalculater.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rewards.rewardcalculater.entity.Transaction;



public interface TransactionRepository extends CrudRepository<Transaction,Long> {
	public List<Transaction> findAllByCustomerId(Long customerId);
	public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from,Timestamp to);

}
