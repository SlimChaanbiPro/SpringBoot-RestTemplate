package com.slim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import com.slim.api.domain.Utilisateur;
import com.slim.api.domain.UtilisateurData;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService
{
    @Autowired
    private RestTemplate restTemplate;

    // inject value from application.properties
    @Value("${api.url}")
    private String API_URL;
  



	@Override
	public List<Utilisateur> getUtilisateurs(Integer limit) {
	    List<Utilisateur> l = new ArrayList<>();
		  UriComponentsBuilder uriBuilder = UriComponentsBuilder
	                .fromUriString(API_URL)
	                .queryParam("limit", String.valueOf(limit - 1));

	        return restTemplate.getForObject(uriBuilder.toUriString(), UtilisateurData.class).getData();
	}
	

}
