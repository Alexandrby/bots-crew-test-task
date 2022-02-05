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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", nullable = false, columnDefinition = "BINARY(16)")
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "department", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Department> departments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", unique = true)
    private Degree degree;

}
