package fun.justdevelops.otpservice.dto;

import fun.justdevelops.otpservice.model.entity.Otp;
import fun.justdevelops.otpservice.model.entity.User;

import java.util.List;

public class GetUserResponse {
    public String login;
    public String role;
    public List<Otp> otps;

    public GetUserResponse(String login, String role, List<Otp> otps) {
        this.login = login;
        this.role = role;
        this.otps = otps;
    }
}
