package com.oncampus.repository;


import com.oncampus.model.CalendarEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEventRepository extends MongoRepository<CalendarEvent, String> {
}