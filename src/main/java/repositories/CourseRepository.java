package repositories;
import Entities.Course;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepositoryImplementation<Course, Long> {
    List<Course> findByOrderById();
}