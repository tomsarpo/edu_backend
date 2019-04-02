package fi.haagahelia.backend.divelog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.backend.divelog.DivelogApplication;
import fi.haagahelia.backend.divelog.domain.UserRepository;

public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(DivelogApplication.class);

	@Autowired  //injektoi repositoryyn
	private UserRepository repository; 
	
	// Show all users
	// localhost:8080/userlist
    @RequestMapping(value="/userlist")
    public String userList(Model model, @RequestParam(defaultValue="0") int page) {	
    	log.info("open userlist");
    	// lisätään sivutustoiminto thymeleafiin
        model.addAttribute("users", repository.findAll( PageRequest.of(page, 4)  ) );
        return "userlist";
    }

}
