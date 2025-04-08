package fun.justdevelops.otpservice.db;

import jakarta.persistence.*;

@Entity
@Table(name = "otp_states")
public class OtpState {
    @Id
    @Column(name = "state")
    private String state;

    // Геттеры и сеттеры
}
