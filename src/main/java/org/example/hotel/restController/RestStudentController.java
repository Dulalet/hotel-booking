//package org.example.hotel.restController;
//
//import org.example.hotel.dto.StudentDto;
//import org.example.hotel.service.StudentService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/rest/api/student")
//public class RestStudentController {
//
//    private final StudentService studentService;
//
//    public RestStudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<StudentDto> getById(@PathVariable Integer id) {
//        StudentDto studentDto = studentService.getById(id);
//        return ResponseEntity.ok(studentDto);
//    }
//
//    @PostMapping("/addStudent")
//    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
//        StudentDto savedStudentDto = studentService.saveStudent(studentDto);
//        return ResponseEntity.ok(savedStudentDto);
//    }
//
//}
