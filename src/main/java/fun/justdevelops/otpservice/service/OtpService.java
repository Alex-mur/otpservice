package fun.justdevelops.otpservice.service;


import fun.justdevelops.otpservice.configuration.exception.RequestException;
import fun.justdevelops.otpservice.dto.GenerateOtpRequest;
import fun.justdevelops.otpservice.dto.ResponseWithMessage;
import fun.justdevelops.otpservice.dto.ValidateOtpRequest;
import fun.justdevelops.otpservice.dto.ValidateOtpResponse;
import fun.justdevelops.otpservice.model.entity.Otp;
import fun.justdevelops.otpservice.model.entity.OtpState;
import fun.justdevelops.otpservice.model.entity.User;
import fun.justdevelops.otpservice.model.repo.OtpConfigRepo;
import fun.justdevelops.otpservice.model.repo.OtpRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Transactional
public class OtpService {
    private final OtpRepo repo;
    OtpConfigRepo otpConfigRepo;

    public OtpService(OtpRepo repo, OtpConfigRepo otpConfigRepo) {
        this.repo = repo;
        this.otpConfigRepo = otpConfigRepo;
    }

    public List<Otp> getUserOtps(String login) {
        return repo.findByUserLogin(login).orElseThrow();
    }

    public long deleteOtpsForUser(String login) {
        return repo.deleteByUserLogin(login);
    }

    public ResponseWithMessage generateOtp(GenerateOtpRequest generateOtpRequest) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var otpConfig = otpConfigRepo.findById(0)
                .orElseThrow(() -> new RequestException("Не удалось найти конфигурацию OTP"));

        if (otpConfig.getLength() <= 0) {
            throw new RequestException("В настройках указана неверная длина OTP кода");
        }

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder otpString = new StringBuilder();

        for (int i = 0; i < otpConfig.getLength(); i++) {
            otpString.append(secureRandom.nextInt(10));
        }

        Otp otp = new Otp(
            generateOtpRequest.getOperationId(),
            Integer.parseInt(otpString.toString()),
            OtpState.ACTIVE,
            user,
            LocalDateTime.now().plusSeconds(otpConfig.getLifetime())
        );
        repo.save(otp);

        return new ResponseWithMessage("OTP код отправлен");
    }

    public ValidateOtpResponse validateOtp(ValidateOtpRequest request) {
        ValidateOtpResponse response = new ValidateOtpResponse(null, false);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        repo.findByUserLogin(user.getLogin()).ifPresent(
                otps -> otps.stream().filter(
                        otp -> otp.getOperationId().equals(request.getOperationId())
                            && otp.getValue().equals(request.getValue()))
                        .findFirst().ifPresent(otp -> {
                            if (otp.getState() == OtpState.ACTIVE) {
                                var now = LocalDateTime.now();
                                if (otp.getExpiresAt().isAfter(now)) {
                                    otp.setUsedAt(now);
                                    otp.setState(OtpState.USED);
                                    repo.save(otp);
                                    response.setValid(true);
                                }
                            }
                            response.setOtp(otp);
                        }));
        return response;
    }
}
