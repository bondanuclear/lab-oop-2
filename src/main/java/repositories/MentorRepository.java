package repositories;


import Entities.Admin;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MentorRepository extends JpaRepositoryImplementation<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}