package fun.justdevelops.otpservice.db;

import jakarta.persistence.*;

@Entity
@Table(name = "otps")
public class Otp {
    @Id
    private Long id;

    @Column(nullable = false)
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "state")
    private OtpState state;

    // Геттеры и сеттеры
}