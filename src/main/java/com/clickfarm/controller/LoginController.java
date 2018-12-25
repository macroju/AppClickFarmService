package com.clickfarm.controller;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clickfarm.consume.Quote;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/request/{user}",method=RequestMethod.GET)
    public LoginUser request(@PathVariable String user){
		
		log.info("the user value is {}",user);
		
		LoginUser loginUser = new LoginUser();
		loginUser.setUsername("Jhon");
		loginUser.setPassword("中文");
		
		return loginUser;
    }
	
	@RequestMapping(value="/consume",method=RequestMethod.GET)
    public Quote consume(){
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("web-proxy.sgp.hp.com", 8080));
        requestFactory.setProxy(proxy);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
		return quote;
    }
	
}
