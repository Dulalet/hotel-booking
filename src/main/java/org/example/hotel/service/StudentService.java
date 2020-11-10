//package org.example.hotel.service;
//
//import org.example.hotel.dto.StudentDto;
//import org.example.hotel.entity.Student;
//import org.example.hotel.repository.StudentRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class StudentService {
//
//    private final StudentRepository studentRepository;
//
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    public StudentDto saveStudent(StudentDto studentDto) {
//
//        Student student = toEntity(studentDto);
//        Student savedStudent= studentRepository.save(student);
//        return toDto(savedStudent);
//    }
//
//    public StudentDto getById(Integer id) {
//        Optional<Student> studentOptional = studentRepository.findById(id);
//        Student student = studentOptional.get();
//        return toDto(student);
//    }
//
//    private Student toEntity(StudentDto studentDto) {
//        return new Student(studentDto.getId(),
//                        studentDto.getFirstName(),
//                        studentDto.getLastName(),
//                        studentDto.getEmail());
//    }
//
//    private StudentDto toDto(Student student) {
//        return new StudentDto(student.getId(),
//                student.getFirstName(),
//                student.getLastName(),
//                student.getEmail());
//    }
//}
