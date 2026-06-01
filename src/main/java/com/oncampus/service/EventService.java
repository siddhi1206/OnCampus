package com.oncampus.service;

import com.oncampus.model.Event;
import com.oncampus.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // CREATE
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // READ ALL
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // READ ONE
    public Event getEventById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // UPDATE
    public Event updateEvent(String id, Event updatedEvent) {

        Event event = getEventById(id);

        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setType(updatedEvent.getType());
        event.setDate(updatedEvent.getDate());

        return eventRepository.save(event);
    }

    // DELETE
    public String deleteEvent(String id) {

        Event event = getEventById(id);

        eventRepository.delete(event);

        return "Event deleted successfully";
    }
}