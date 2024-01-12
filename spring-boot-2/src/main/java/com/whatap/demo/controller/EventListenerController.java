package com.whatap.demo.controller;


import com.whatap.demo.service.EventListenerService;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventListenerController {

  private final EventListenerService eventListenerService;

  @GetMapping("/event")
  public CompletableFuture<Void> event(@RequestParam(value = "async", required = false, defaultValue = "false") boolean async) {
    if (async) {
      eventListenerService.asyncProcess();
    } else {
      eventListenerService.process();
    }
    return CompletableFuture.completedFuture(null);
  }


  @GetMapping("/transactional-event")
  public CompletableFuture<Void> transactionalEvent(@RequestParam(value = "async", required = false, defaultValue = "false") boolean async) {
    if (async) {
      eventListenerService.asyncTransactionalProcess();
    } else {
      eventListenerService.transactionalProcess();
    }
    return CompletableFuture.completedFuture(null);
  }

}
