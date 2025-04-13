package fun.justdevelops.otpservice.model.repo;

import fun.justdevelops.otpservice.model.entity.Otp;
import org.springframework.data.repository.CrudRepository;

public interface OtpRepo extends CrudRepository<Otp, Long> {
}
