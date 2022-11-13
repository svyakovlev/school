package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeBetween(int min, int max);

    List<Student> findStudentsByFacultyId(Long id);

    Student findStudentById(Long id);

    @Query(value = "SELECT count (*) from Student", nativeQuery = true)
    Long getStudentsCount();

    @Query(value ="SELECT avg(age) from Student", nativeQuery = true)
    Long getAverageStudentsAge();

    @Query(value = "SELECT * from Student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> getLastFiveStudents();
}
