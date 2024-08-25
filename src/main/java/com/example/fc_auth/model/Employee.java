package com.example.fc_auth.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Entity
@Getter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long departmentId;

    @ManyToMany
    @JoinTable(
            name = "employee_role_mapping",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
}
