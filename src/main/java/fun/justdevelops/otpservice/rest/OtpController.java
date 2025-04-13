package fun.justdevelops.otpservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OtpController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}
