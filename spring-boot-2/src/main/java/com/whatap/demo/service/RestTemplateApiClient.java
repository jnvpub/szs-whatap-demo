package com.whatap.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestTemplateApiClient extends ExternalApiClient{

    private final RestTemplate restTemplate;

    private String baseUrl = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public String getData() {
        return restTemplate.getForObject(baseUrl, String.class);
    }
}
