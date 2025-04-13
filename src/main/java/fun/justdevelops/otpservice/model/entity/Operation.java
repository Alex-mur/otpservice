package fun.justdevelops.otpservice.model.entity;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Otp getOtp() {
        return otp;
    }

    public void setOtp(Otp otp) {
        this.otp = otp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
