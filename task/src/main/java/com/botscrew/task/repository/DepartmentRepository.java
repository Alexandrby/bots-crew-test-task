package com.botscrew.task.repository;

import com.botscrew.task.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> getDepartmentsByName(String name);

    @Query(value = "SELECT lector_id from lector_departments where department_id = ?1", nativeQuery = true)
    Set<Long> findAllLectorsByIdDepartment(Long id);

}
