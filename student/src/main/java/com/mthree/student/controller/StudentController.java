package com.mthree.student.controller;

import com.mthree.student.entity.Student;
import com.mthree.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return  studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody  Student student){
        return studentService.updateStudent(id, student);
    }
}
