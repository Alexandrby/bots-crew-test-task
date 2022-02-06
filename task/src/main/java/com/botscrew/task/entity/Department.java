package com.botscrew.task.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "head_of_department_id")
    private Long headOfDepartmentId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lector_departments", joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"))
    @Column(name = "lector_id")
    private Set<String> lectors;
}
