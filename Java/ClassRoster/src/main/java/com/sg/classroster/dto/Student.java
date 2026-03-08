package com.sg.classroster.dto;

import java.util.Objects;

public record Student(String firstName, String lastName, String studentId, String cohort) {
}