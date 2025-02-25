package com.springdatajpa;

import com.github.javafaker.Faker;
import com.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> saveStudents(studentRepository);
    }

    @Transactional
    public void saveStudents(StudentRepository studentRepository) {
//        Student student1 = new Student("ly", "hong", "lorn@gmail.com", 24);
//        Student student2 = new Student("lorn", "kong", "ly@gmail.com", 23);
//
//        studentRepository.saveAll(List.of(student1, student2));
//        System.out.println("Saved students successfully!");
//
//
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@gmail.com";

        for (int i = 1; i <= 20; i++){
            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(18, 45));
            studentRepository.save(student);
        }

        System.out.print("Count of students: ");
        System.out.println("Number of students : " + studentRepository.count());
    }
}
