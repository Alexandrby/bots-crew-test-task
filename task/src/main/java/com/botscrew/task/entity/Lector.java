package com.botscrew.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "lector")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lector_departments", joinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id"))
    @Column(name = "department_id")
    private Set<String> departments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "degree_lectors", joinColumns = @JoinColumn(name = "lector_id"), inverseJoinColumns = @JoinColumn(name = "degree_id"))
    private Degree degree;

}
