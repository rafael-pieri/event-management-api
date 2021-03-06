package com.eventmanagement.repos;

import com.eventmanagement.model.Organizer;

import org.springframework.data.repository.PagingAndSortingRepository;

@SuppressWarnings("unused")
public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}