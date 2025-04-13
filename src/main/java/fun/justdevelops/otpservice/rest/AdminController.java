package fun.justdevelops.otpservice.rest;


import fun.justdevelops.otpservice.dto.SetOtpConfigRequest;
import fun.justdevelops.otpservice.model.entity.OtpConfig;
import fun.justdevelops.otpservice.service.OtpConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final OtpConfigService otpConfigService;

    @Autowired
    public AdminController(OtpConfigService otpConfigService) {
        this.otpConfigService = otpConfigService;
    }

    @GetMapping("/get-otp-config")
    public OtpConfig getOtpConfig() {
        return otpConfigService.get();
    }

    @PostMapping("/set-otp-config")
    public OtpConfig setOtpConfig(@RequestBody SetOtpConfigRequest request) {
        return otpConfigService.set(request);
    }
}
