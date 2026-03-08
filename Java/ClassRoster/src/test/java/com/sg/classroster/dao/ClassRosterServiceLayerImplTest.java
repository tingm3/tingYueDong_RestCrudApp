package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIdException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ClassRosterServiceLayerImplTest {
    private ClassRosterServiceLayer service;

    public ClassRosterServiceLayerImplTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }

    @Test
    public void testCreateValidStudent() {
        // ARRANGE
        Student student = new Student("Charles","Babbage","0002", ".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException
                 | ClassRosterDataValidationException
                 | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Student was valid. No exception should have been thrown.");
        }
    }
    @Test
    public void testCreateDuplicateIdStudent() {
        // ARRANGE
        Student student = new Student("Babbage","Charles","0001",".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
            fail("Expected DupeId Exception was not thrown.");
        } catch (ClassRosterDataValidationException
                 | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDuplicateIdException e){
            return;
        }
    }
    @Test
    public void testGetAllStudents() throws Exception {
        // ARRANGE
        Student testClone = new Student("Ada","Lovelace","0001","Java-May-1845");

        // ACT & ASSERT
        assertEquals( 1, service.getAllStudents().size(),
                "Should only have one student.");
        assertTrue( service.getAllStudents().contains(testClone),
                "The one student should be Ada.");
    }
    @Test
    public void testGetStudent() throws Exception {
        // ARRANGE
        Student testClone = new Student("Ada","Lovelace","0001","Java-May-1845");

        // ACT & ASSERT
        Student shouldBeAda = service.getStudent("0001");
        assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
        assertEquals( testClone, shouldBeAda,
                "Student stored under 0001 should be Ada.");

        Student shouldBeNull = service.getStudent("0042");
        assertNull( shouldBeNull, "Getting 0042 should be null.");
    }
    @Test
    public void testRemoveStudent() throws Exception {
        // ARRANGE
        Student testClone = new Student("Ada","Lovelace","0001","Java-May-1845");

        // ACT & ASSERT
        Student shouldBeAda = service.removeStudent("0001");
        assertNotNull( shouldBeAda, "Removing 0001 should be not null.");
        assertEquals( testClone, shouldBeAda, "Student removed from 0001 should be Ada.");

        Student shouldBeNull = service.removeStudent("0042");
        assertNull( shouldBeNull, "Removing 0042 should be null.");

    }


}
