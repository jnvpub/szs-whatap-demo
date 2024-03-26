package com.whatap.demo.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "exampleClient", url = "https://jsonplaceholder.typicode.com")
public interface ExampleClient {
    @GetMapping("/posts")
    String getData();
}