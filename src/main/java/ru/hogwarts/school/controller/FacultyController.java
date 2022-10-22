package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Map;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("{FacultyId}")
    public ResponseEntity readFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.readFaculty(facultyId);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{FacultyId}")
    public Faculty deleteFaculty(@PathVariable Long facultyId) {
        return facultyService.deleteFaculty(facultyId);
    }

    @GetMapping("{age}")
    public Map<Long, Faculty> filterFacultyByColor(@PathVariable String color) {
        return facultyService.filterFacultyByColor(color);
    }
}
