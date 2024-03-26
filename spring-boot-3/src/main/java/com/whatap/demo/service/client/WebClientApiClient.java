package com.whatap.demo.service.client;

import com.whatap.demo.service.client.ExternalApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
@RequiredArgsConstructor
public class WebClientApiClient extends ExternalApiClient {
    private final WebClient webClient;

    private String baseUrl = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public String getData() {
        return webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // 주의: 실제 사용 시에는 block() 대신 비동기 처리 방법 고려
    }
}
