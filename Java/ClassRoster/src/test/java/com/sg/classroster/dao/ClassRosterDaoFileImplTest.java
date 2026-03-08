package com.sg.classroster.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sg.classroster.dto.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassRosterDaoFileImplTest {
    ClassRosterDao testDao;

    public ClassRosterDaoFileImplTest() {
    }
    @BeforeEach
    void setUp() throws Exception {
        String testFile = "testroster.txt";

        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addStudent() throws ClassRosterPersistenceException {
        String studentId = "0001";
        Student student = new Student("Ada","Lovelace", studentId, "Java-May-1845");


        //  Add the student to the DAO
        testDao.addStudent(studentId, student);
        // Get the student from the DAO
        Student retrievedStudent = testDao.getStudent(studentId);

        // Check the data is equal
        assertEquals(student.studentId(),
                retrievedStudent.studentId(),
                "Checking student id.");
        assertEquals(student.firstName(),
                retrievedStudent.firstName(),
                "Checking student first name.");
        assertEquals(student.lastName(),
                retrievedStudent.lastName(),
                "Checking student last name.");
        assertEquals(student.cohort(),
                retrievedStudent.cohort(),
                "Checking student cohort.");
    }

    @Test
    void getAllStudents() throws ClassRosterPersistenceException {
        Student firstStudent = new Student("Ada", "Lovelace", "0001", "Java-May-1845");

        Student secondStudent = new Student("Charles", "Babbage", "0002", ".NET-May-1845");
        testDao.addStudent(firstStudent.studentId(), firstStudent);
        testDao.addStudent(secondStudent.studentId(), secondStudent);

        // Retrieve the list of all students within the DAO
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull(allStudents, "The list of students must not null");
        assertEquals(2, allStudents.size(),"List of students should have 2 students.");

        // Then the specifics
        assertTrue(testDao.getAllStudents().contains(firstStudent),
                "The list of students should include Ada.");
        assertTrue(testDao.getAllStudents().contains(secondStudent),
                "The list of students should include Charles.");
    }

    @Test
    void getStudent() throws ClassRosterPersistenceException {
        Student firstStudent = new Student("Ada", "Lovelace", "0001", "Java-May-1845");
        Student secondStudent = new Student("Charles", "Babbage", "0002", ".NET-May-1845");

        testDao.addStudent(firstStudent.studentId(), firstStudent);
        testDao.addStudent(secondStudent.studentId(), secondStudent);

        // Get a student that exists
        Student retrievedStudent = testDao.getStudent("0001");
        assertNotNull(retrievedStudent, "Ada should not be null.");
        assertEquals(firstStudent, retrievedStudent, "Retrieved student should be Ada.");

        // Get a student that does not exist
        Student nonExistentStudent = testDao.getStudent("9999");
        assertNull(nonExistentStudent, "Non-existent student should be null.");
    }

    @Test
    void removeStudent() throws ClassRosterPersistenceException {
        Student firstStudent = new Student("Ada", "Lovelace", "0001", "Java-May-1845");

        Student secondStudent = new Student("Charles", "Babbage", "0002", ".NET-May-1845");
        testDao.addStudent(firstStudent.studentId(), firstStudent);
        testDao.addStudent(secondStudent.studentId(), secondStudent);
        Student removedStudent = testDao.removeStudent(firstStudent.studentId());

        assertEquals(removedStudent, firstStudent, "The removed student should be Ada.");

        // Get all the students
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull( allStudents, "All students list should be not null.");
        assertEquals( 1, allStudents.size(), "All students should only have 1 student.");

        // Then the specifics
        assertFalse( allStudents.contains(firstStudent), "All students should NOT include Ada.");
        assertTrue( allStudents.contains(secondStudent), "All students should  include Charles.");

        // Remove the second student
        removedStudent = testDao.removeStudent(secondStudent.studentId());
        assertEquals( removedStudent, secondStudent, "The removed student should be Charles.");

        allStudents = testDao.getAllStudents();
        assertTrue( allStudents.isEmpty(), "The retrieved list of students should be empty.");

        // Try to 'get' both students by their old id - they should be null!
        Student retrievedStudent = testDao.getStudent(firstStudent.studentId());
        assertNull(retrievedStudent, "Ada was removed, should be null.");

        retrievedStudent = testDao.getStudent(secondStudent.studentId());
        assertNull(retrievedStudent, "Charles was removed, should be null.");

    }
}