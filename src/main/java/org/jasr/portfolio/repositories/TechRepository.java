package org.jasr.portfolio.repositories;

import org.jasr.portfolio.entities.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<Tech, Long> {

}
