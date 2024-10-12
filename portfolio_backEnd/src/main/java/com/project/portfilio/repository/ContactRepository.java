package com.project.portfilio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.portfilio.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

