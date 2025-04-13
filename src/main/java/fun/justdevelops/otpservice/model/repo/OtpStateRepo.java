package fun.justdevelops.otpservice.model.repo;

import fun.justdevelops.otpservice.model.entity.OtpState;
import org.springframework.data.repository.CrudRepository;

public interface OtpStateRepo extends CrudRepository<OtpState, Long> {
}
