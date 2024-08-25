package com.example.fc_auth.repository;

import com.example.fc_auth.model.Department;
import com.example.fc_auth.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
