package com.example.session07.controller;

import com.example.session07.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.core.codec.ResourceEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("message","Dữ liệu sinh viên hợp lệ");
        response.put("data",studentDTO);
        return ResponseEntity.ok(response);
    }
}
