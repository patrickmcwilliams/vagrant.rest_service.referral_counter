package com.demo.rest.referral_counter;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CounterController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/counter")
    public Counter counter(@RequestParam(value="url", defaultValue="none") String url,
    						@RequestParam(value="clientid", defaultValue="none") String clientId) {
        Counter counter = new Counter();
        counter.recordURL(url, clientId);
        return counter;
    }
	
}
