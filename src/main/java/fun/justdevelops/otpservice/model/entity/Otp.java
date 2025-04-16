package fun.justdevelops.otpservice.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "otps")
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "state")
    private OtpState state;

    @ManyToOne
    @JoinColumn(name = "user_login")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public OtpState getState() {
        return state;
    }

    public void setState(OtpState state) {
        this.state = state;
    }
}