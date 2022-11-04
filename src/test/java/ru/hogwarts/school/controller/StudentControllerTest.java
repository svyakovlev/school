package ru.hogwarts.school.controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void createStudentTest() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("StudentTest");
        student.setAge(35);

        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }

    @Test
    public void readStudentTest() throws Exception{
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", Student.class))
                .isNotNull();
    }

    @Test
    public void filterStudentsByAge() throws Exception{
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/age", Student.class))
                .isNotNull();
    }

    @Test
    public void findByAgeBetween() throws Exception{
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/findByAgeBetween", Student.class))
                .isNotNull();
    }

    @Test
    public void findStudentsByFacultyId() throws Exception{
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/findStudentsByFacultyId", Student.class))
                .isNotNull();
    }

    @Test
    public void findFacultyByStudentId() throws Exception{
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/findFacultyByStudentId", Student.class))
                .isNotNull();
    }
}
