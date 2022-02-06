package com.botscrew.task.service;

import com.botscrew.task.entity.Degree;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
    void shouldGetHeadOfDepartmentTest() {
        // GIVEN
        String departmentName = "test";
        Long id = 1L;
        Optional<Department> optionalDepartment = Optional.of(new Department(id, "name", 1L));
        Lector lector = mock(Lector.class);

        // WHEN
        when(departmentRepository.getDepartmentsByName(departmentName)).thenReturn(optionalDepartment);
        when(lectorRepository.getById(id)).thenReturn(lector);


        // THEN
        departmentService.getHeadOfDepartment(departmentName);
        verify(departmentRepository, times(1)).getDepartmentsByName(departmentName);
        verify(lectorRepository, times(1)).getById(optionalDepartment.get()
                .getHeadOfDepartmentId());
        verifyNoMoreInteractions(departmentRepository);
        verifyNoMoreInteractions(lectorRepository);
    }

    @Test
    void shouldGetDepartmentStatisticsTest() {
        String departmentName = "test";
        Long id = 1L;
        Optional<Department> optionalDepartment = Optional.of(new Department(id, "name", 1L));
        Lector lector = createLector(1L);
        Set <Long> lectors = Set.of(1L,2L);

        // WHEN
        when(departmentRepository.getDepartmentsByName(departmentName)).thenReturn(optionalDepartment);
        when(departmentRepository.findAllLectorsByIdDepartment(id)).thenReturn(lectors);
        when(lectorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(lector));

        //THEN
        departmentService.getDepartmentStatistics(departmentName);
        verify(departmentRepository ).getDepartmentsByName(departmentName);
        verify(departmentRepository ).findAllLectorsByIdDepartment(id);
        verify(lectorRepository, times(2)).findById(anyLong());

    }

    @Test
    void shouldGetCountEmployeeTest() {
        // GIVEN
        String departmentName = "test";
        Long id = 1L;
        Optional<Department> optionalDepartment = Optional.of(new Department(id, "name", 1L));
        Lector lector = mock(Lector.class);
        Set <Long> lectors = mock(Set.class);

        // WHEN
        when(departmentRepository.getDepartmentsByName(departmentName)).thenReturn(optionalDepartment);
        when(departmentRepository.findAllLectorsByIdDepartment(id)).thenReturn(lectors);

    }

    private Lector createLector(Long id){
       return  Lector.builder()
                .id(id)
                .name("Иванов Иван Иваныч")
                .salary(435.0)
                .departments(Set.of("TO"))
                .degree(new Degree(1l,"ASSISTANS"))
                .build();
    }

}
