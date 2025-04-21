package fun.justdevelops.otpservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SignUpRequest {
    private String login;
    private String password;
    private String email;
}
