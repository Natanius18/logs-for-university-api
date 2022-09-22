package software.sigma.logsforuniversityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.sigma.logsforuniversityapi.entity.LogRecord;

@Repository
public interface LogRepository extends JpaRepository<LogRecord, Long> {
}
