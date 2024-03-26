package com.whatap.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignApiClient extends ExternalApiClient {

    private final ExampleClient exampleClient;

    @Override
    public String getData() {
        return exampleClient.getData();
    }
}
