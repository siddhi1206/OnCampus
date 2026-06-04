package com.oncampus.service;

import com.oncampus.model.Event;
import com.oncampus.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    // Create
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Read All
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Read By Id
    public Event getEventById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // Update
    public Event updateEvent(String id, Event updatedEvent) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setCategory(updatedEvent.getCategory());
        event.setEventDate(updatedEvent.getEventDate());
        event.setRegistrationDeadline(updatedEvent.getRegistrationDeadline());
        event.setRegistrationLink(updatedEvent.getRegistrationLink());
        event.setOrganizer(updatedEvent.getOrganizer());

        return eventRepository.save(event);
    }

    // Delete
    public String deleteEvent(String id) {

        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found");
        }

        eventRepository.deleteById(id);

        return "Event deleted successfully";
    }
}