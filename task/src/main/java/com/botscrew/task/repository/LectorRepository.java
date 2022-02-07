package com.botscrew.task.repository;

import com.botscrew.task.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    Set<Lector> findByNameContaining(String word);
}
