package com.botscrew.task.service;

import com.botscrew.task.entity.Department;
import com.botscrew.task.entity.Lector;
import com.botscrew.task.repository.DepartmentRepository;
import com.botscrew.task.repository.LectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private LectorRepository lectorRepository;
    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void shouldGetHeadOfDepartment() {
        // GIVEN
        String departMentName = "test";
        String name = "name";
        Long id = 1L;
        Optional<Department> optionalDepartment = Optional.of(new Department(id, "name", 1L));
        Lector lector = mock(Lector.class);

        // WHEN
        when(departmentRepository.getDepartmentsByName(departMentName)).thenReturn(optionalDepartment);
        when(lectorRepository.getById(id)).thenReturn(lector);
        departmentService.getHeadOfDepartment(departMentName);

        // THEN
        verify(departmentRepository, times(1)).getDepartmentsByName(departMentName);
        verify(lectorRepository, times(1)).getById(optionalDepartment.get()
                .getHeadOfDepartmentId());
        verifyNoMoreInteractions(departmentRepository);
        verifyNoMoreInteractions(lectorRepository);
    }

}
