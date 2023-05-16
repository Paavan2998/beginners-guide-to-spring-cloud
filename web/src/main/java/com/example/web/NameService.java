package com.example.web;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Paavan Shah on 16-05-2023.
 */
@Service
public class NameService {
    private static final String URL = "http://localhost:6070/getName";
    private RestTemplate rest;

    public NameService(RestTemplate rest) {
        this.rest = rest;
    }

    public String getName(){
        return rest.getForObject(URL, String.class);
    }
}
