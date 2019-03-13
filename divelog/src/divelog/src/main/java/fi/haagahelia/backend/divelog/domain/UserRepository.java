package fi.haagahelia.backend.divelog.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByfirstName(String firstName);
}
