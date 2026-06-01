package com.oncampus.controller;

import com.oncampus.model.Event;
import com.oncampus.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educator/event")
public class EventController {

    @Autowired
    private EventService eventService;

    // CREATE
    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Event updateEvent(
            @PathVariable String id,
            @RequestBody Event event) {

        return eventService.updateEvent(id, event);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable String id) {
        return eventService.deleteEvent(id);
    }
}