package fi.haagahelia.backend.divelog.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface DiveLogRepository extends JpaRepository<DiveLog, Long>{

	List<DiveLog> findByPlace(String place);
}
