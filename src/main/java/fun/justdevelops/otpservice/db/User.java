package fun.justdevelops.otpservice.db;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String spass;

    private String role;

    // Геттеры и сеттеры
}
