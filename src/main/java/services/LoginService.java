package services;

import Entities.Admin;
import Entities.Student;
import lombok.SneakyThrows;
import org.keycloak.TokenVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Service
public class LoginService {
    public Student getCurrentStudent() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (Student) principal;
    }

    public Admin getCurrentMentor() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (Admin) principal;
    }
}
