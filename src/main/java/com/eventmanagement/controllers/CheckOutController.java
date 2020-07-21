package com.eventmanagement.controllers;

import com.eventmanagement.model.Participant;
import com.eventmanagement.exceptions.NotCheckedInException;
import com.eventmanagement.repos.ParticipantRepository;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class CheckOutController {

    private final ParticipantRepository participantRepository;

    public CheckOutController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<PersistentEntityResource> checkout(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
        Participant participant = participantRepository.findOne(id);

        if (participant == null) {
            throw new ResourceNotFoundException();
        }

        if (!participant.getCheckedIn()) {
            throw new NotCheckedInException();
        }
        participant.setCheckedIn(false);
        participantRepository.save(participant);

        return ResponseEntity.ok(assembler.toResource(participant));
    }
}