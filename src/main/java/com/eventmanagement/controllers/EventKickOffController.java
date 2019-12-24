package com.eventmanagement.controllers;

import com.eventmanagement.entities.Event;
import com.eventmanagement.repos.EventRepository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

    private final EventRepository eventRepository;

    public EventKickOffController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping("/start/{id}")
    public ResponseEntity start(@PathVariable Long id) {
        Event event = eventRepository.findOne(id);

        if (event == null) {
            throw new ResourceNotFoundException();
        }

        event.setStarted(true);
        eventRepository.save(event);

        return ResponseEntity.ok(event.getName() + " has started");
    }
}