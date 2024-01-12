package com.whatap.demo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "event_listener")
public class EventListenerEntity extends BaseEntity {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "async", nullable = false)
  private boolean async;

  @Column(name = "transactional", nullable = false)
  private boolean transactional;

  @Column(name = "message", nullable = false)
  private String message;

  @Builder
  public EventListenerEntity(boolean async, boolean transactional, String message) {
    this.async = async;
    this.transactional = transactional;
    this.message = message;
  }
}
