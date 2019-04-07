package fi.haagahelia.backend.divelog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long>{
	
}
