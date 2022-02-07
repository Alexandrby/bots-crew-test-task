package com.botscrew.task.service;

import com.botscrew.task.entity.Department;
import com.botscrew.task.entity.Lector;
import com.botscrew.task.repository.DepartmentRepository;
import com.botscrew.task.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;


    public void getHeadOfDepartment(String nameOfDepartment) {

        Optional<Department> department = Optional.ofNullable(departmentRepository.getDepartmentsByName(nameOfDepartment).orElseThrow(() -> new RuntimeException("Department has not been found")));
        Long idHeadOfDepartment = department
                .stream()
                .findFirst()
                .map(Department::getHeadOfDepartmentId)
                .orElseThrow(() -> new RuntimeException("Department has not been found"));
        System.out.println("Head of " + nameOfDepartment + " " + lectorRepository.getById(idHeadOfDepartment).getName() + "\n");
    }

    public void getDepartmentStatistics(String nameOfDepartment) {
        Optional<Department> department = Optional.ofNullable(departmentRepository.getDepartmentsByName(nameOfDepartment).orElseThrow(() -> new RuntimeException("Department has not been found")));
        Long idOfDepartment = department
                .stream()
                .findFirst()
                .map(Department::getId)
                .orElseThrow(() -> new RuntimeException("Department has not been found"));
        departmentRepository.findAllLectorsByIdDepartment(idOfDepartment)
                .stream()
                .map(lectorRepository::findById)
                .map(Optional::get)
                .collect(Collectors.groupingBy(d -> d.getDegree().getTitle(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " - " + value + "\n"));
    }

    public void getAverageSalary(String nameOfDepartment) {
        Optional<Department> department = Optional.ofNullable(departmentRepository.getDepartmentsByName(nameOfDepartment).orElseThrow(() -> new RuntimeException("Department has not been found")));
        Long idOfDepartment = department
                .stream()
                .findFirst()
                .map(Department::getId)
                .orElseThrow(() -> new RuntimeException("Department has not been found"));

        Double averageSalary = departmentRepository.findAllLectorsByIdDepartment(idOfDepartment)
                .stream()
                .map(lectorRepository::findById)
                .map(Optional::get)
                .mapToDouble(Lector::getSalary).average().getAsDouble();
        System.out.println("The average salary of " + nameOfDepartment + " is " + averageSalary + "\n");
    }

    public void getCountEmployee(String nameOfDepartment) {
        Optional<Department> department = Optional.ofNullable(departmentRepository.getDepartmentsByName(nameOfDepartment).orElseThrow(() -> new RuntimeException("Department has not been found")));
        Long idOfDepartment = department
                .stream()
                .findFirst()
                .map(Department::getId)
                .orElseThrow(() -> new RuntimeException("Department has not been found"));
        Integer countEmployee = departmentRepository.findAllLectorsByIdDepartment(idOfDepartment)
                .size();
        System.out.println(countEmployee);
    }

    public void findAllLectorsByWord(String word) {
        lectorRepository.findByNameContaining(word)
                .stream()
                .map(Lector::getName)
                .forEach(System.out::println);
    }
}

