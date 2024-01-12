package com.whatap.demo.service;


import com.whatap.demo.jpa.EventListenerEntity;
import com.whatap.demo.jpa.EventListenerRepository;
import java.util.concurrent.CompletableFuture;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EventListenerComponent {

  private final EventListenerRepository eventListenerRepository;

  @EventListener
  public String process(NormalEvent event) {
    return saveEvent(event);
  }

  @Async
  @EventListener
  public CompletableFuture<String> process(AsyncEvent event) {
    return CompletableFuture.completedFuture(saveEvent(event));
  }


  @Async
  @TransactionalEventListener
  @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
  public CompletableFuture<String> process(AsyncTransactionalEvent event) {
    return CompletableFuture.completedFuture(saveEvent(event));
  }


  @TransactionalEventListener
  @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
  public String process(TransactionalEvent event) {
    return saveEvent(event);
  }

  private String saveEvent(Event event) {
    EventListenerEntity saved = eventListenerRepository.save(EventListenerEntity.builder()
        .async(event.async)
        .transactional(event.transactional)
        .message(event.getMessage())
        .build());
    return saved.getMessage();
  }

  @Getter
  @RequiredArgsConstructor
  private static class Event {

    protected final String message;
    protected final boolean async;
    protected final boolean transactional;

    public Event(String message) {
      this.message = message;
      this.async = false;
      this.transactional = false;
    }
  }

  @Getter
  public static class NormalEvent extends Event {

    public NormalEvent(String message) {
      super(message);
    }
  }


  @Getter
  public static class AsyncEvent extends Event {

    public AsyncEvent(String message) {
      super(message, true, false);
    }
  }

  @Getter
  public static class AsyncTransactionalEvent extends Event {

    public AsyncTransactionalEvent(String message) {
      super(message, true, true);
    }
  }

  @Getter
  public static class TransactionalEvent extends Event {

    public TransactionalEvent(String message) {
      super(message, false, true);
    }
  }

}
