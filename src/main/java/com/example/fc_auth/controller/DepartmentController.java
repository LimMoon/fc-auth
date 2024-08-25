package com.example.fc_auth.controller;

import com.example.fc_auth.model.Department;
import com.example.fc_auth.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
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
public class DepartmentController {
    private final DepartmentService departmentService;

    @Operation(description = "전사 부서 조회")
    @GetMapping(value = "/departments",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Department>> listAll(){
        return new ResponseEntity<>(departmentService.listDepartments(), HttpStatus.OK);
    }
}
