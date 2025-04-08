package fun.justdevelops.otpservice.db;

import jakarta.persistence.*;

@Entity
@Table(name = "operations")
public class Operation {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "otp_id", nullable = false)
    private Otp otp;

    private String description;

    // Геттеры и сеттеры
}
