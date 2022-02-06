package com.botscrew.task.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DepartmentView {

    private Scanner scanner = new Scanner(System.in);

    public String getNameOfDepartment() {
        System.out.println("Choose name of department ");
        String nameOfDepartment = scanner.nextLine();

        return nameOfDepartment;
    }

}
