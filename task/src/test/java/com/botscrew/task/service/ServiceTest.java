package com.botscrew.task.service;

import com.botscrew.task.repository.DepartmentRepository;
import com.botscrew.task.repository.LectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
public class ServiceTest {

    private final DepartmentRepository departmentRepository = mock(DepartmentRepository.class);
    private final LectorRepository lectorRepository = mock(LectorRepository.class);
    private  DepartmentService departmentService = getService();

    public DepartmentService getService() {
        if (departmentService == null) {
            departmentService = new DepartmentService(departmentRepository, lectorRepository);
        }
        return departmentService;
    }


    @Test
    public void shouldGetHeadOfDepartment(String nameOfDepartment){
        when()
    }
}
