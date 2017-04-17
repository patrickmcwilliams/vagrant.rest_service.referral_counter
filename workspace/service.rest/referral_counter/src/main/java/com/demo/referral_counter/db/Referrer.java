package com.demo.referral_counter.db;
import org.springframework.data.annotation.Id;

public class Referrer {

    @Id
    public String id;

    public String url;
    public String clientId;
    public String total;

    public Referrer() {}
    
    public Referrer(String url, String clientId){
    	this.url = url;
    	this.clientId = clientId;
    }
    
}
