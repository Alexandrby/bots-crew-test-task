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
        }
    }

    private void getHeadOfDepartment() {
        String nameOfDepartment = departmentView.getNameOfDepartment();
        departmentService.getHeadOfDepartment(nameOfDepartment);
        execute();
    }

    private void getDepartmentStatistics() {
        String nameOfDepartment = departmentView.getNameOfDepartment();
        departmentService.getDepartmentStatistics(nameOfDepartment);
        execute();
    }

    private void getAverageSalary() {
        String nameOfDepartment = departmentView.getNameOfDepartment();
        departmentService.getAverageSalary(nameOfDepartment);
        execute();
    }

    private void getCountOfEmployee() {
        String nameOfDepartment = departmentView.getNameOfDepartment();
        departmentService.getCountEmployee(nameOfDepartment);
        execute();
    }

    private void findAllLectorsByWord() {
        String nameOfDepartment = departmentView.getWordForFind();
        departmentService.findAllLectorsByWord(nameOfDepartment);
        execute();
    }

}
