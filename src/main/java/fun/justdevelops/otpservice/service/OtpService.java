package fun.justdevelops.otpservice.service;


import fun.justdevelops.otpservice.model.entity.Otp;
import fun.justdevelops.otpservice.model.repo.OtpRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OtpService {
    private final OtpRepo repo;

    public OtpService(OtpRepo repo) {
        this.repo = repo;
    }

    public List<Otp> getUserOtps(String login) {
        return repo.findByUserLogin(login).orElseThrow();
    }

    public long deleteOtpsForUser(String login) {
        return repo.deleteByUserLogin(login);
    }
}
