package com.botscrew.task.view;

import com.botscrew.task.entity.Department;
import com.botscrew.task.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class DepartmentView {
    private final DepartmentRepository departmentRepository;
    private final Scanner scanner = new Scanner(System.in);

    public String getNameOfDepartment() {
        System.out.println("Choose name of department from list:");
        departmentRepository.findAll()
                .stream()
                .map(Department::getName)
                .forEach(System.out::println);

        return scanner.nextLine();
    }

    public String getWordForFind() {
        System.out.println("Enter a search term:");

        return scanner.nextLine();
    }

}
