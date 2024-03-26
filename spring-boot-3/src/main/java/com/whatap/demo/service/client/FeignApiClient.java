package com.whatap.demo.service.client;

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
