package com.eventmanagement.repos;

import com.eventmanagement.entities.Organizer;

import org.springframework.data.repository.PagingAndSortingRepository;

@SuppressWarnings("unused")
public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}