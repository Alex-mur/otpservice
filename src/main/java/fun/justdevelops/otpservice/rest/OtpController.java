package fun.justdevelops.otpservice.rest;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.AuthProvider;

@RestController
@RequestMapping("/api")
public class OtpController {

    @GetMapping("/hello")
    public String hello() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "Hello, " + username;
    }
}
