package com.project.portfilio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.portfilio.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
