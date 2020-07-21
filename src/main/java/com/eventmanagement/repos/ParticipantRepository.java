package com.eventmanagement.repos;

import com.eventmanagement.model.Participant;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

@SuppressWarnings("unused")
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

    Page<Participant> findByEmail(@Param("email") String email, Pageable pageable);

    Optional<Participant> findById(@Param("id") Long id);
}