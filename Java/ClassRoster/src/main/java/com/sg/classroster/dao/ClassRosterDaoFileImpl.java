package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.io.*;
import java.util.*;

public class ClassRosterDaoFileImpl implements ClassRosterDao {
    private final String ROSTER_FILE;
    public static final String DELIMITER = "::";
    private Map<String, Student> students = new HashMap<>();

    public ClassRosterDaoFileImpl(){
        ROSTER_FILE = "roster.txt";
    }
    public ClassRosterDaoFileImpl(String rosterTextFile){
        ROSTER_FILE = rosterTextFile;
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {

        loadRoster();return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {

        loadRoster();return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {

        loadRoster();
        Student removedStudents = students.remove(studentId);
        writeRoster();
        return removedStudents;
    }

    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0];
        return new Student(studentTokens[0], studentTokens[1], studentTokens[2], studentTokens[3]);
    }

    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Student currentStudent;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.studentId(), currentStudent);
        }
        scanner.close();
    }

    private String marshallStudent(Student aStudent) {
        String studentAsText = aStudent.studentId() + DELIMITER;
        studentAsText += aStudent.firstName() + DELIMITER;
        studentAsText += aStudent.lastName() + DELIMITER;
        studentAsText += aStudent.cohort();
        return studentAsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
     * for file format.
     *
     * @throws ClassRosterPersistenceException if an error occurs writing to the file
     */
    private void writeRoster() throws ClassRosterPersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException(
                    "Could not save student data.", e);
        }

        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            studentAsText = marshallStudent(currentStudent);

            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }
}