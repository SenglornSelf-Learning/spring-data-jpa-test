package com.springdatajpa;

import com.springdatajpa.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    @Transactional
//    public void saveStudents(){
//        List<Student> studentList = Arrays.asList(
//                new Student("Senglorn", "Ly", "senglorn@gmail.com", 24),
//                new Student("Kim", "Ly", "kim@gmail.com", 23)
//        );
//
//        studentRepository.saveAll(studentList);
//    }
}
