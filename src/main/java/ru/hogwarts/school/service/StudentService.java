package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long studentId = 1;

    public Student createStudent(Student student) {
        students.put(studentId, student);
        studentId++;
        return student;
    }

    public Student readStudent(long studentId) {
        return students.get(studentId);
    }

    public Student updateStudent(long studentId, Student student) {
        students.put(studentId, student);
        return student;
    }

    public Student deleteStudent(long studentId) {
        return students.remove(studentId);
    }
}
