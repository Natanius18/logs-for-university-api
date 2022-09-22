package software.sigma.logsforuniversityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.sigma.logsforuniversityapi.entity.Parameter;

@Repository
public interface ParamRepository extends JpaRepository<Parameter, Long> {
}
