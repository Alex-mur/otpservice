package fun.justdevelops.otpservice.dto;

public class SetOtpConfigRequest {
    private Integer lifetime;
    private Integer length;

    public SetOtpConfigRequest(Integer lifetime, Integer length) {
        this.lifetime = lifetime;
        this.length = length;
    }

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
