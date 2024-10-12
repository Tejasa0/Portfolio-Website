package com.project.portfilio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.portfilio.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
