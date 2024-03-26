package com.whatap.demo.service;


import com.whatap.demo.jpa.AsyncEntity;
import com.whatap.demo.jpa.AsyncRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final AsyncRepository asyncRepository;
    private final FeignApiClient feignApiClient;
    private final WebClientApiClient webClientApiClient;
    private final RestTemplateApiClient restTemplateApiClient;

    @Async
    public CompletableFuture<String> processAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                asyncRepository.save(AsyncEntity.builder()
                        .status("async")
                        .build());
                Thread.sleep(5000); // 5초 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Completed";
        });
    }


    @Async
    public void externalApiCall() {
        feignApiClient.getData();
        webClientApiClient.getData();
        restTemplateApiClient.getData();
    }

}
