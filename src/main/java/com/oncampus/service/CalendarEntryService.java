package com.oncampus.service;

import com.oncampus.model.CalendarEntry;
import com.oncampus.repository.CalendarEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEntryService {

    private final CalendarEntryRepository repository;

    public CalendarEntryService(CalendarEntryRepository repository) {
        this.repository = repository;
    }

    // Create
    public CalendarEntry createEntry(CalendarEntry entry) {
        return repository.save(entry);
    }

    // Get All
    public List<CalendarEntry> getAllEntries() {
        return repository.findAll();
    }

    // Get By Id
    public CalendarEntry getEntryById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Calendar Entry Not Found"));
    }

    // Update
    public CalendarEntry updateEntry(String id, CalendarEntry updatedEntry) {

        CalendarEntry existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Calendar Entry Not Found"));

        existing.setTitle(updatedEntry.getTitle());
        existing.setDescription(updatedEntry.getDescription());
        existing.setCategory(updatedEntry.getCategory());
        existing.setStartDate(updatedEntry.getStartDate());
        existing.setEndDate(updatedEntry.getEndDate());
        existing.setCreatedBy(updatedEntry.getCreatedBy());

        return repository.save(existing);
    }

    // Delete
    public void deleteEntry(String id) {
        repository.deleteById(id);
    }
}