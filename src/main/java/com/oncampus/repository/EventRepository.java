package com.oncampus.repository;

import com.oncampus.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByEducatorId(String educatorId);
}