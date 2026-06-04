package com.oncampus.service;

import com.oncampus.model.CalendarEvent;
import com.oncampus.repository.CalendarEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarEventService {

    private final CalendarEventRepository repository;

    public CalendarEvent create(CalendarEvent event) {
        return repository.save(event);
    }

    public List<CalendarEvent> getAll() {
        return repository.findAll();
    }

    public CalendarEvent getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar event not found: " + id));
    }

    public CalendarEvent update(String id, CalendarEvent updatedEvent) {

        CalendarEvent event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar event not found: " + id));

        event.setTitle(updatedEvent.getTitle());
        event.setType(updatedEvent.getType());
        event.setDate(updatedEvent.getDate());

        return repository.save(event);
    }

    public CalendarEvent delete(String id) {

        CalendarEvent event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar event not found: " + id));

        repository.delete(event);

        return event;
    }
}