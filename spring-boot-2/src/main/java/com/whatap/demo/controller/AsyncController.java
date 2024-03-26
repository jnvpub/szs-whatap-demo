package com.whatap.demo.controller;


import com.whatap.demo.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/process")
    public CompletableFuture<String> process() {
        return asyncService.processAsync();
    }


    @GetMapping("/call")
    public void externalApiCall() {
        asyncService.externalApiCall();
    }

}
