package com.demo.referral_counter.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WebController {
	
	@Autowired
	private WebService webService;
	
    public WebController(){}
    
    @RequestMapping(value = {"/index.html", "/"}, method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "index";
	}
    
}
