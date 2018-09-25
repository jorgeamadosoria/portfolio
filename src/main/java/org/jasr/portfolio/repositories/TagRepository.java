package org.jasr.portfolio.repositories;

import org.jasr.portfolio.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
