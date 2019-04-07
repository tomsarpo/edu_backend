package fi.haagahelia.backend.divelog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.text.SimpleDateFormat;

import fi.haagahelia.backend.divelog.domain.AdminUser;
import fi.haagahelia.backend.divelog.domain.AdminUserRepository;
import fi.haagahelia.backend.divelog.domain.User;
import fi.haagahelia.backend.divelog.domain.UserRepository;
import fi.haagahelia.backend.divelog.domain.DiveLog;
import fi.haagahelia.backend.divelog.domain.DiveLogRepository;

@SpringBootApplication
public class DivelogApplication {
	private static final Logger log = LoggerFactory.getLogger(DivelogApplication.class);
	
	//main program
	public static void main(String[] args) {
		SpringApplication.run(DivelogApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner justDemo(UserRepository urepository, AdminUserRepository aurepository, DiveLogRepository drepository) {
		return (args) -> {
			log.info("fill database");
			
			log.info("fill admin users");
			aurepository.save(new AdminUser("Tomi", "S", "1234", true));
			
			log.info("fill users");
			urepository.save(new User("Sami", "K", "123456", false));
			urepository.save(new User("Petri", "H", "321", false));
			
			log.info("fill divelogs");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			//konstruktori public DiveLog(User user, Date date, String place, String diveplan, String comment, String image)
			drepository.save(new DiveLog(urepository.findByfirstName("Tomi").get(0), formatter.parse("2018-01-11"), "meri", "diveplan...", "comment...", null));
			drepository.save(new DiveLog(urepository.findByfirstName("Tomi").get(0), formatter.parse("2018-02-21"), "järvi", "diveplan...", "comment...", null));
			drepository.save(new DiveLog(urepository.findByfirstName("Sami").get(0), formatter.parse("2018-02-21"), "järvi", "diveplan...", "comment...", null));
			
			log.info("fetch data");
			
			for (DiveLog divelog : drepository.findAll()) {
				log.info(divelog.toString());
			}
			for (User user : urepository.findAll()) {
				log.info(user.toString());
			}

		};
	}

}

