package com.demo.referral_counter.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<?> counterGet(@RequestParam(value="action", defaultValue="count") String action,
    									@RequestParam(value="url", defaultValue="none") String url,
    									@RequestParam(value="clientid", defaultValue="none") String clientId) {
		Map<String, String> data = new HashMap<>();
		data.put("url", url);
		data.put("clientId", clientId);
    	switch(action){	
    		case "list":
    			return service.listRecords(data);
    		case "count":
    			return service.countRecords(data);
    		case "topThree":
    			data.put("queryType", "topThree");
    			return service.listRecords(data);	
    	}

    	return null;
    }
	
}
