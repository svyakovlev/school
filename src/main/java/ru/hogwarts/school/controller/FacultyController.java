package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity readFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.readFaculty(id);
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color/{color}")
    public List<Faculty> filterFacultyByColor(@PathVariable String color) {
        return facultyService.filterFacultyByColor(color);
    }

    @GetMapping("/filterByNameOrColor")
    public List<Faculty> filterByNameOrColor(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String color) {
        return facultyService.filterByNameOrColor(name, color);
    }

//    @GetMapping("/findFacultyByStudentId")
//    public Faculty findFacultyByStudentId(@RequestParam Long id) {
//        return studentService;
//    }
}
