package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
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

    public Map<Long, Faculty> filterFacultyByColor(String color) {
        return faculties.entrySet().stream()
                .filter(e -> e.getValue().getColor() == color)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
