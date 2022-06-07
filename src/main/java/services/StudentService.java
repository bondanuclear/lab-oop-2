package services;

import DTO.EnrollRequest;
import DTO.StudentResponse;
import Entities.Course;
import Entities.Student;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import repositories.CourseRepository;
import repositories.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final LoginService loginService;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentResponse getStudent() {
        Student student = loginService.getCurrentStudent();
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getUsername())
                .amount(student.getAmount())
                .build();
    }

    @SneakyThrows
    public void enrollOnCourse(EnrollRequest request) {
        Student student = loginService.getCurrentStudent();
        Course course = courseRepository.getById(request.getCourseId());
        course.setPrice(course.getCount() - request.getCount());
        student.setAmount(student.getAmount() - course.getPrice() * request.getCount());
        courseRepository.save(course);
        studentRepository.save(student);
    }
}
