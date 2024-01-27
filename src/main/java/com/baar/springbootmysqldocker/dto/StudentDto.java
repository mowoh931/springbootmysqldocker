package com.baar.springbootmysqldocker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String email;
}
