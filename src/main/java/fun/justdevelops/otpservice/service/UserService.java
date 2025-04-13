package fun.justdevelops.otpservice.service;

import fun.justdevelops.otpservice.model.entity.User;
import fun.justdevelops.otpservice.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }

    public User create(User user) {
        if (repo.existsByLogin(user.getLogin())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }

    public User getByLogin(String login) {
        return repo.findByLogin(login).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByLogin;
    }

    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByLogin(username);
    }

}
