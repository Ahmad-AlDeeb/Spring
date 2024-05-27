package com.deeb.eurekaservicediscovery.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public String getAllUsers() {
        return restTemplate.getForObject("http://USER-SERVICE/api/v1/users", String.class);
    }
}
