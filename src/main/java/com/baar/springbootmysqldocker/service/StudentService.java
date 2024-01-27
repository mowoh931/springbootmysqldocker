package com.baar.springbootmysqldocker.service;

import com.baar.springbootmysqldocker.dto.StudentDto;
import com.baar.springbootmysqldocker.model.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(StudentDto dto);

    public List<StudentDto> getStudents();

    public Student getStudentById(int id);

    public void updateStudent(StudentDto dto);

    public void deleteStudent(int id);


}
