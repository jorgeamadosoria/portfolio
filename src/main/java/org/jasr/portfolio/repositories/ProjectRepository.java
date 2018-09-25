package org.jasr.portfolio.repositories;

import org.jasr.portfolio.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
