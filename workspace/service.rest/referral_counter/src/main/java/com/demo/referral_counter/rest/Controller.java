package com.demo.referral_counter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.referral_counter.db.Referrer;


@RestController
public class Controller {
	
	@Autowired
	private Service service;
	
    public Controller(){}
    
    @RequestMapping(value="/counter/set")
    public Service counterSet(@RequestParam(value="url", defaultValue="none") String url,
    						@RequestParam(value="clientid", defaultValue="0") String clientId) {
    	service.recordURL(url, clientId);
        return service;
    }
    
    @RequestMapping(value="/counter/get")
    public List<Referrer> counterGet(@RequestParam(value="url", defaultValue="none") String url,
    						@RequestParam(value="clientid", defaultValue="0") String clientId) {
        
    	return service.getRecords();
    }
	
}
