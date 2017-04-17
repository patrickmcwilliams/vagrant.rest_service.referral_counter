package com.demo.referral_counter.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.referral_counter.db.Referrer;
import com.demo.referral_counter.db.ReferrerRepository;

@Component("service")
public class Service {
	
	@Autowired
	private ReferrerRepository db;
	
	private String url;
	private String clientId;
	private String status = "success";
	
	public void recordURL(String url, String clientId){
		this.clientId = clientId;
		this.url = url;
		try{
			Referrer referrer = new Referrer(url, clientId);
			db.save(referrer);
		}
		catch(Exception e){
			this.status = "fail";
		}
	}
	
	public List<Referrer> getRecords(){
		List<Referrer> list = db.findByClientId("0");
		return list;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public String getClientId(){
		return this.clientId;
	}
	
	public String getStatus(){
		return this.status;
	}
}
