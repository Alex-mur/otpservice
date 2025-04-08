package fun.justdevelops.otpservice.db;

import jakarta.persistence.*;

@Entity
@Table(name = "otp_conf")
public class OtpConfig {
    @Id
    @Column(nullable = false)
    private Integer lifetime;

    // Геттеры и сеттеры
}
