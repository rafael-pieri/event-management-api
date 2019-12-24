package com.eventmanagement.controllers;

import com.eventmanagement.entities.Participant;
import com.eventmanagement.exceptions.AlreadyCheckedInException;
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
public class CheckInController {

    private final ParticipantRepository participantRepository;

    public CheckInController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
        Participant participant = participantRepository.findOne(id);

        if (participant == null) {
            throw new ResourceNotFoundException();
        }

        if (participant.getCheckedIn()) {
            throw new AlreadyCheckedInException();
        }

        participant.setCheckedIn(true);
        participantRepository.save(participant);

        return ResponseEntity.ok(assembler.toResource(participant));
    }
}