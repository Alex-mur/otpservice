package fun.justdevelops.otpservice.model.entity;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "otp_conf")
public class OtpConfig {
    @Id
    private Integer id = 0;

    @Column(nullable = false)

    private Integer lifetime = 120;

    @Column(nullable = false)
    private Integer length = 4;

    public Integer getLifetime() {
        return lifetime;
    }

    public void setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
