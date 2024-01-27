package com.baar.springbootmysqldocker.service;

import com.baar.springbootmysqldocker.dto.StudentDto;
import com.baar.springbootmysqldocker.exception.StudentAlreadyRegistered;
import com.baar.springbootmysqldocker.model.Student;
import com.baar.springbootmysqldocker.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(StudentDto dto) {
        studentRepository.findById(dto.getId()).ifPresent(s -> {
            try {
                throw new StudentAlreadyRegistered("Student already exists");
            } catch (StudentAlreadyRegistered e) {
                throw new RuntimeException(e);
            }
        });
        Student student = Student.builder().id(dto.getId()).first_name(dto.getFirst_name()).last_name(dto.getLast_name()).age(dto.getAge()).email(dto.getEmail()).build();
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> students = new LinkedList<>();
        try {
            students = studentRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return students.stream().map(student -> StudentDto.builder().id(student.getId()).first_name(student.getFirst_name()).last_name(student.getLast_name()).age(student.getAge()).email(student.getEmail()).build()).toList();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void updateStudent(StudentDto dto) {


    }

    @Override
    public void deleteStudent(int id) {

    }


    public Object getStudent() throws IOException {

//        JCodeModel codeModel = new JCodeModel();
//        URL source = Example.class.getResource("https://randomuser.me/api/");
//
//        GenerationConfig config = new DefaultGenerationConfig() {
//            @Override
//            public boolean isGenerateBuilders() {
//                return true;
//            }
//        };
//
//        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
//        mapper.generate(codeModel, "Person", "springbootmysqldocker", source);
//
//        codeModel.build(Files.createTempDirectory("required").toFile());

        return null;

    }


}
