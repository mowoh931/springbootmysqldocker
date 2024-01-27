package com.baar.springbootmysqldocker.controller;

import com.baar.springbootmysqldocker.dto.StudentDto;
import com.baar.springbootmysqldocker.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentServiceImpl studentService;
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save/student")
    public void saveStudent(@RequestBody StudentDto dto) {
        try {
            studentService.saveStudent(dto);
            logger.info("Student saved successfully {}", dto.getFirst_name());

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @GetMapping("/get/all/students")
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }


}
