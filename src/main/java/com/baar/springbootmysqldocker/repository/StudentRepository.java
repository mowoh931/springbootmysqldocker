package com.baar.springbootmysqldocker.repository;

import com.baar.springbootmysqldocker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
