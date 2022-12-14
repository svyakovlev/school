package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("{id}")
    public ResponseEntity readStudent(@PathVariable Long id) {
        Student student = studentService.readStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/age/{age}")
    public List<Student> filterStudentsByAge(@PathVariable int age) {
        return studentService.filterStudentsByAge(age);
    }

    @GetMapping("/findByAgeBetween")
    public List<Student> findByAgeBetween(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeBetween(min, max);
    }

    @GetMapping("/findStudentsByFaculty/{id}")
    public List<Student> findStudentsByFacultyId(@PathVariable Long id) {
        return studentService.findStudentsByFacultyId(id);
    }

    @GetMapping("/findFacultyByStudentId")
    public Faculty findFacultyByStudentId(@RequestParam Long id) {
        return studentService.findFacultyByStudentId(id);
    }

    @GetMapping("/count")
    public Long getStudentsCount() {
        return studentService.getStudentsCount();
    }

    @GetMapping("/averageStudentsAge")
    public Long getAverageStudentsAge() {
        return studentService.getAverageStudentsAge();
    }

    @GetMapping("/lastFiveStudent")
    public List<Student> getLastFiveStudent() {
        return studentService.getLastFiveStudent();
    }

    @GetMapping("/StudentsWhoseNameStartsWithLetterA")
    public List<String> getStudentsWhoseNameStartsWithLetterA() {
        return studentService.getStudentsWhoseNameStartsWithLetterA();
    }

    @GetMapping("/findAverageStudentsAge")
    public Double findAverageStudentsAge() {
        return studentService.findAverageStudentsAge();
    }
}
