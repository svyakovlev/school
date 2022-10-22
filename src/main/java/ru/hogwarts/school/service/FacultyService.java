package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long facultyId = 1;

    public Faculty createFaculty(Faculty faculty) {
        faculties.put(facultyId, faculty);
        facultyId++;
        return faculty;
    }

    public Faculty readFaculty(long facultyId) {
        return faculties.get(facultyId);
    }

    public Faculty updateFaculty(long facultyId, Faculty faculty) {
        faculties.put(facultyId, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long facultyId) {
        return faculties.remove(facultyId);
    }
}
