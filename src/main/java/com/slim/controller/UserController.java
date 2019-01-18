package com.slim.controller;

import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.AssertFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;

import com.slim.api.domain.DpcEmployee;
import com.slim.api.domain.Utilisateur;
import com.slim.api.domain.UtilisateurData;
import com.slim.services.ApiService;

@Slf4j
@Controller
public class UserController
{
	 @Autowired
	   RestTemplate SpringClientBuilder;
		
	    @Autowired
	    private ApiService apiService;
	    
	    
	    
	    
	    
	    
	   @Value("${api.cisco}")
	    private String url;
	   
	   
	   @Value("${api.url}")
	    private String api;

	   private ClientHttpRequestFactory getClientHttpRequestFactory() {
   	    int timeout = 5000;
   	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
   	      = new HttpComponentsClientHttpRequestFactory();
   	    clientHttpRequestFactory.setConnectTimeout(timeout);
   	    return clientHttpRequestFactory;
   	}

    @RequestMapping(value = {"", "/", "/index"})
    public String showUsers(Model model)
    {
        return "userlist";
    }

    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter =   new MarshallingHttpMessageConverter();
 
 
        return xmlConverter;
    }

    public void configureMessageConverters(
    	      List<HttpMessageConverter<?>> converters) {
    	     
    	converters.add(createXmlHttpMessageConverter());
    	converters.add(new MappingJackson2HttpMessageConverter());
    	 
    	    }

    
     public DpcEmployee[] fonction1() {
    	 createXmlHttpMessageConverter();
    	   HttpHeaders headers = new HttpHeaders();
    	   headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    	   headers.setContentType(MediaType.APPLICATION_JSON);
    	
    	 ResponseEntity<String> response = SpringClientBuilder.getForEntity(api, String.class);
    	
    	
    	String a =SpringClientBuilder.getForObject(url, String.class, 200);
    	DpcEmployee[] listdpc =SpringClientBuilder.getForObject("http://localhost:8090/all", DpcEmployee[].class, 200);
    	
    	   if (listdpc != null) {
               for (DpcEmployee e : listdpc) {
                   System.out.println("Employee: " + e.getNom() + " - " + e.getPrenom());
               }}
    	
    	 System.out.println(a); 
 
    		
    		
    		return  listdpc;
    		
     }
   
     @PostMapping("/users")
     public String formPostssss(Model model, ServerWebExchange serverWebExchange)
     {

         MultiValueMap<String, String> map = serverWebExchange.getFormData().block();
  
 model.addAttribute("users", fonction1());
 
 System.out.println(model.addAttribute("users",fonction1()));
         return "userlist";
     }
}
