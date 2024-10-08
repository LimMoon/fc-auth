package com.example.fc_auth.service;

import com.example.fc_auth.model.Employee;
import com.example.fc_auth.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> listEmployees(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Security Context Holder name: " + name);
        return employeeRepository.findAll();
    }

    public Employee createEmployee(String firstName, String lastName, Long departmentId, String kakaoNickName) {
        if(employeeRepository.existsByKakaoNickName(kakaoNickName)){
            throw new DuplicateKeyException("같은 카카오 닉네임이 존재합니다");
        }

        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .departmentId(departmentId)
                .kakaoNickName(kakaoNickName)
                .build();
        employeeRepository.save(employee);
        return employee;
    }
}
