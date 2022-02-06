package com.botscrew.task.service;

import com.botscrew.task.entity.Department;
import com.botscrew.task.entity.Lector;
import com.botscrew.task.repository.DepartmentRepository;
import com.botscrew.task.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    public void getHeadOfDepartment(String nameOfDepartment) {

        Optional<Department> department = Optional.ofNullable(departmentRepository.getDepartmentsByName(nameOfDepartment).orElseThrow(() -> new RuntimeException("Department has not been found")));
        Long idHeadOfDepartment = department.get().getHeadOfDepartmentId();
        System.out.println("Head of " + nameOfDepartment + " " + lectorRepository.getById(idHeadOfDepartment).getName() + "\n");

    }

    public void getDepartmentStatistics (String nameOfDepartment){
        Optional<Department> department = Optional.ofNullable(departmentRepository.getDepartmentsByName(nameOfDepartment).orElseThrow(() -> new RuntimeException("Department has not been found")));
        Long idOfDepartment = department.get().getId();
        List<Lector> lectorsFromDepartment =
    }

}

