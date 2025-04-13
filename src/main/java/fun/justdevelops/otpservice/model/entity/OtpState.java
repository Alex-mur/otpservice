package fun.justdevelops.otpservice.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "otp_states")
public class OtpState {
    @Id
    @Column(name = "state")
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
