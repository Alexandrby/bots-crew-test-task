package com.botscrew.task.controller;

import com.botscrew.task.service.DepartmentService;
import com.botscrew.task.view.DepartmentView;
import com.botscrew.task.view.MainView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentView departmentView;
    private final MainView mainView;
    private final DepartmentService departmentService;

    @GetMapping("/task")
    public void execute() {

        switch (mainView.executeChoice()) {
            case 1:
                getHeadOfDepartment();
                break;
            case 2:
                getDepartmentStatistics();
                break;
            case 3:
                getAverageSalary();
                break;
            case 4:
                getCountOfEmployee();
                break;
            case 5:
                findAllLectorsByWord();
                break;
            default:
                System.out.println("Wrong number, pleas  choose form 1 to 5");
                execute();
        }
    }

    private void getHeadOfDepartment() {
        try {
            String nameOfDepartment = departmentView.getNameOfDepartment();
            departmentService.getHeadOfDepartment(nameOfDepartment);
            execute();
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            getHeadOfDepartment();
        }
    }

    private void getDepartmentStatistics() {
        try {
            String nameOfDepartment = departmentView.getNameOfDepartment();
            departmentService.getDepartmentStatistics(nameOfDepartment);
            execute();
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            getHeadOfDepartment();
        }
    }

    private void getAverageSalary() {
        try {
            String nameOfDepartment = departmentView.getNameOfDepartment();
            departmentService.getAverageSalary(nameOfDepartment);
            execute();
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            getHeadOfDepartment();
        }
    }

    private void getCountOfEmployee() {
        try {
            String nameOfDepartment = departmentView.getNameOfDepartment();
            departmentService.getCountEmployee(nameOfDepartment);
            execute();
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            getHeadOfDepartment();
        }
    }

    private void findAllLectorsByWord() {
        try {
            String nameOfDepartment = departmentView.getWordForFind();
            departmentService.findAllLectorsByWord(nameOfDepartment);
            execute();
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            getHeadOfDepartment();
        }
    }

}
