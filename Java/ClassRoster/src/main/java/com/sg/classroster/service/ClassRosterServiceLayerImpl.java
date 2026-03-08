package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;

import java.util.List;

public class ClassRosterServiceLayerImpl implements
        ClassRosterServiceLayer {
    ClassRosterDao dao;
    ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.firstName() == null
                || student.firstName().trim().length() == 0
                || student.lastName() == null
                || student.lastName().trim().length() == 0
                || student.cohort() == null
                || student.cohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }

    @Override
    public void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException {

        if (dao.getStudent(student.studentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                            + student.studentId()
                            + " already exists");
        }

        validateStudentData(student);

        dao.addStudent(student.studentId(), student);
        auditDao.writeAuditEntry(
                "Student " + student.studentId() + " CREATED.");
    }

    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent =  dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
}
