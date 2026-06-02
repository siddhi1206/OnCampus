package com.oncampus.controller;

import com.oncampus.model.CalendarEntry;
import com.oncampus.service.CalendarEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@CrossOrigin("*")
public class CalendarEntryController {

    private final CalendarEntryService service;

    public CalendarEntryController(CalendarEntryService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public CalendarEntry createEntry(
            @RequestBody CalendarEntry entry) {

        return service.createEntry(entry);
    }

    // Get All
    @GetMapping
    public List<CalendarEntry> getAllEntries() {
        return service.getAllEntries();
    }

    // Get By Id
    @GetMapping("/{id}")
    public CalendarEntry getEntryById(
            @PathVariable String id) {

        return service.getEntryById(id);
    }

    // Update
    @PutMapping("/{id}")
    public CalendarEntry updateEntry(
            @PathVariable String id,
            @RequestBody CalendarEntry entry) {

        return service.updateEntry(id, entry);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteEntry(
            @PathVariable String id) {

        service.deleteEntry(id);

        return "Calendar Entry Deleted Successfully";
    }
}