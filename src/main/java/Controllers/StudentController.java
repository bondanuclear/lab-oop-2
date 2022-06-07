package Controllers;

import DTO.EnrollRequest;
import DTO.StudentResponse;
import Entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/servlet_war_exploded/current-user")
    public StudentResponse getCurrentStudent() {
        return studentService.getStudent();
    }

    @PostMapping("/servlet_war_exploded/enroll-on-course")
    public void orderDrink(@RequestBody EnrollRequest request) {
        studentService.enrollOnCourse(request);
    }
}
