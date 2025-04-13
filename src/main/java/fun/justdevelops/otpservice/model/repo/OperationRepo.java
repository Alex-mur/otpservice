package fun.justdevelops.otpservice.model.repo;

import fun.justdevelops.otpservice.model.entity.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepo extends CrudRepository<Operation, Long> {
}
