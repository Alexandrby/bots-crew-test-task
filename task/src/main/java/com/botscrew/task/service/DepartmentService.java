package com.botscrew.task.service;

import com.botscrew.task.entity.Department;
import com.botscrew.task.repository.DepartmentRepository;
import com.botscrew.task.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    public String getHeadOfDepartment(String nameOfDepartment) {

        Optional<Department> department = departmentRepository.getDepartmentsByName(nameOfDepartment);

        Long id = department.get().getHeadOfDepartmentId();
        System.out.println("Head of " + nameOfDepartment + " " + lectorRepository.getById(id).getName() + "\n");
        return lectorRepository.getById(id).getName();
    }

}

