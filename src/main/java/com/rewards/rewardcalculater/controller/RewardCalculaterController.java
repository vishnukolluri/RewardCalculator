package com.rewards.rewardcalculater.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.rewardcalculater.entity.Customer;
import com.rewards.rewardcalculater.entity.Transaction;
import com.rewards.rewardcalculater.model.Rewards;
import com.rewards.rewardcalculater.service.CustomerService;
import com.rewards.rewardcalculater.service.RewardService;
import com.rewards.rewardcalculater.service.TransactionService;

@RestController
@RequestMapping("/")
public class RewardCalculaterController {
	

	@Autowired
	private RewardService rewardService;

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CustomerService customerService;
	
	 @GetMapping(value = "getRewards/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> getPointsByCustomerId(@PathVariable("customerId") Long customerId){
	        Customer customer = customerService.findCustomerByCustomerId(customerId);
	        if(customer == null)
	        {
	        	Map<String,String> errorMap=new HashMap<>();
	        	errorMap.put("errorMessage", "No Member Found");
		        return new ResponseEntity<>(errorMap,HttpStatus.OK);
	        }
	        Rewards rewards = rewardService.getPointsByCustomerId(customerId);
	        return new ResponseEntity<>(rewards,HttpStatus.OK);
	    }
	 @GetMapping(value = "transaction/{transactionId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> getTransactionById(@PathVariable("transactionId") Long id){
	        Transaction transaction = transactionService.findAllByCustomerId(id);
	        if(transaction == null)
	        {
	        	Map<String,String> errorMap=new HashMap<>();
	        	errorMap.put("errorMessage", "No Transaction Found");
		        return new ResponseEntity<>(errorMap,HttpStatus.OK);
	        }
	        return new ResponseEntity<>(transaction,HttpStatus.OK);
	    }
	 @GetMapping(value = "customers/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> getCustomerById(@PathVariable("customerId") Long id){
	        Customer customer = customerService.findCustomerByCustomerId(id);
	        if(customer == null)
	        {
	        	Map<String,String> errorMap=new HashMap<>();
	        	errorMap.put("errorMessage", "No Customer Found");
		        return new ResponseEntity<>(errorMap,HttpStatus.OK);
	        }
	        return new ResponseEntity<>(customer,HttpStatus.OK);
	    }
}
