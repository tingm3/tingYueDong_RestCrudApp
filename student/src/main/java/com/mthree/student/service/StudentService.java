package com.mthree.student.service;

import com.mthree.student.entity.Student;
import com.mthree.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public  Student addStudent(Student  student){
        return  studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent( Long id,  Student student){
        Student student1 = studentRepository.findById(id).orElse(null);
        if(student1 != null){
            student1.setName(student.getName());
            student1.setFees(student.getFees());
            student1.setSubject(student.getSubject());
            studentRepository.save(student1);
            return  student1;
        }
        return null;
    }


}
