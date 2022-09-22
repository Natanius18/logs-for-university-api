package software.sigma.logsforuniversityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.sigma.logsforuniversityapi.entity.Parameter;

public interface ParamRepository extends JpaRepository<Parameter, Long> {
}
