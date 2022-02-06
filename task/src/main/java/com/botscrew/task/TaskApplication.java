package com.botscrew.task;

import com.botscrew.task.controller.DepartmentController;
import com.botscrew.task.repository.DepartmentRepository;
import com.botscrew.task.service.DepartmentService;
import com.botscrew.task.view.DepartmentView;
import com.botscrew.task.view.MainView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RequiredArgsConstructor
public class TaskApplication {


	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

	}

}
