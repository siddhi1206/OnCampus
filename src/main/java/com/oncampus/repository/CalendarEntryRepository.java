package com.oncampus.repository;

import com.oncampus.model.CalendarEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEntryRepository
        extends MongoRepository<CalendarEntry, String> {
}