package com.whatap.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventListenerRepository extends JpaRepository<EventListenerEntity, Long> {

}
