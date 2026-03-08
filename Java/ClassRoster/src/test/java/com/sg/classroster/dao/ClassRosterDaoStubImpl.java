package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassRosterDaoStubImpl implements  ClassRosterDao {
    private Student onlyStudent;

    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("Ada","Lovelace","0001","Java-May-1845" );
    }

    public ClassRosterDaoStubImpl(Student onlyStudent) {
        this.onlyStudent = onlyStudent;
    }

    @Override
    public Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.studentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterPersistenceException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(onlyStudent);
        return studentList;
    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.studentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.studentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

}

