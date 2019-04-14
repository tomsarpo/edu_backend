package fi.haagahelia.backend.divelog.divelog;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import fi.haagahelia.backend.divelog.domain.User;
import fi.haagahelia.backend.divelog.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByNameShouldReturnUser() {
	List<User> users = repository.findByfirstName("Tomi");
	assertThat(users).hasSize(1);
	assertThat(users.get(0).getFirstName()).isEqualTo("John");
	}
	
	@Test
	public void createNewUser() {
	User test = new User("Saara", "R", "1234", true);
	repository.save(test);
	assertThat(test.getId()).isNotNull();
	}
	
}
