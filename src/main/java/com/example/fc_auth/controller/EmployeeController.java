package com.example.fc_auth.controller;

import com.example.fc_auth.model.Employee;
import com.example.fc_auth.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="Basics", description = "기본 관리 API")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/employees",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listAll(){
        return new ResponseEntity<>(employeeService.listEmployees(), HttpStatus.OK);
    }
}
