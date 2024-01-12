package com.whatap.demo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
