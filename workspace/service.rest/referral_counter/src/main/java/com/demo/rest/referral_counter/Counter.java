package com.demo.rest.referral_counter;

public class Counter {
	
	private String url;
	private String clientId;
	private String status = "success";
	
	public void recordURL(String url, String clientId){
		this.clientId = clientId;
		this.url = url;
		try{
			//db record
		}
		catch(Error e){
			this.status = "fail";
		}
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
