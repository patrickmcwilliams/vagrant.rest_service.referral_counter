package com.demo.referral_counter.web;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ErrorFourOFourController implements ErrorController{
	private static final String PATH = "/error";
    
    
    @RequestMapping(value = PATH, method = RequestMethod.GET)
	public String error(Map<String, Object> model) {
		return "error";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}	
}
