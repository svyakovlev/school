package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger("StudentServise");
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student readStudent(long id) {
        logger.info("Was invoked method for read student");
        return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent(Student student) {
        logger.info("Was invoked method for update student");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.warn("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public List<Student> filterStudentsByAge(int age) {
        logger.info("Was invoked method for filter student by age");
        return studentRepository.findAll().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }

    public List<Student> findByAgeBetween(int min, int max) {
        logger.info("Was invoked method for find student by age");
        return studentRepository.findByAgeBetween(min, max);
    }

    public List<Student> findStudentsByFacultyId(Long id) {
        logger.info("Was invoked method for find students by faculty id");
        return studentRepository.findStudentsByFacultyId(id);
    }

    public Faculty findFacultyByStudentId(Long id) {
        logger.info("Was invoked method for find faculty by student id");
        return studentRepository.findStudentById(id).getFaculty();
    }

    public Student getById(Long studentId) {
        logger.info("Was invoked method for find student by id");
        return studentRepository.findStudentById(studentId);
    }

    public Long getStudentsCount() {
        logger.info("Was invoked method for get student count");
        return studentRepository.getStudentsCount();
    }

    public Long getAverageStudentsAge() {
        logger.info("Was invoked method for get average students age");
        return studentRepository.getAverageStudentsAge();
    }

    public List<Student> getLastFiveStudent() {
        logger.info("Was invoked method for get last five student");
        return studentRepository.getLastFiveStudents();
    }

    public List<String> getStudentsWhoseNameStartsWithLetterA() {
        List<String> studentsWithLetterA;
        studentsWithLetterA = studentRepository.findAll()
                .stream()
                .filter(s -> s.getName().startsWith("A"))
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        return studentsWithLetterA;
    }

    public Double findAverageStudentsAge() {
        Double averageStudentAge;
        averageStudentAge = studentRepository.findAll()
                .stream()
                .collect(Collectors.averagingInt(Student::getAge));
        return averageStudentAge;
    }
}