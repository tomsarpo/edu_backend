package fi.haagahelia.backend.divelog.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DiveLogRepository extends CrudRepository<DiveLog, Long>{

	List<DiveLog> findByPlace(String place);
}
