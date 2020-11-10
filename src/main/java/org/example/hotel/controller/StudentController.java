//package org.example.hotel.controller;
//
//import org.example.hotel.dto.StudentDto;
//import org.example.hotel.service.StudentService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/studentPage")
//public class StudentController {
//
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @GetMapping("/stud")
//    public String studentPage(Model model) {
//        StudentDto student = studentService.getById(1);
//        model.addAttribute("student", student);
//        return "index";
//    }
//}
