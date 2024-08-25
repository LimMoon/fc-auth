package com.example.fc_auth.service;

import com.example.fc_auth.model.Department;
import com.example.fc_auth.model.Employee;
import com.example.fc_auth.repository.DepartmentRepository;
import com.example.fc_auth.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> listDepartments(){
        return departmentRepository.findAll();
    }
}
