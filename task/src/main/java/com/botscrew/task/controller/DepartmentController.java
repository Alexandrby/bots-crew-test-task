package com.botscrew.task.controller;

import com.botscrew.task.service.DepartmentService;
import com.botscrew.task.view.DepartmentView;
import com.botscrew.task.view.MainView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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

        }
    }

    public void getHeadOfDepartment() {
        String nameOfDepartment = departmentView.getNameOfDepartment();
        departmentService.getHeadOfDepartment(nameOfDepartment);
        mainView.executeChoice();

    }


}
