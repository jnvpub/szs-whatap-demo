package com.whatap.demo.service;


import com.whatap.demo.service.EventListenerComponent.AsyncEvent;
import com.whatap.demo.service.EventListenerComponent.AsyncTransactionalEvent;
import com.whatap.demo.service.EventListenerComponent.NormalEvent;
import com.whatap.demo.service.EventListenerComponent.TransactionalEvent;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventListenerService {

  private final ApplicationEventPublisher applicationEventPublisher;

  public void process() {
    applicationEventPublisher.publishEvent(new NormalEvent(UUID.randomUUID().toString()));
  }

  public void asyncProcess() {
    applicationEventPublisher.publishEvent(new AsyncEvent(UUID.randomUUID().toString()));
  }

  @Transactional("transactionManager")
  public void transactionalProcess() {
    applicationEventPublisher.publishEvent(new TransactionalEvent(UUID.randomUUID().toString()));
  }

  @Transactional("transactionManager")
  public void asyncTransactionalProcess() {
    applicationEventPublisher.publishEvent(new AsyncTransactionalEvent(UUID.randomUUID().toString()));
  }

}
