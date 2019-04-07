package fi.haagahelia.backend.divelog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.backend.divelog.DivelogApplication;
import fi.haagahelia.backend.divelog.domain.AdminUserRepository;

@Controller //asetetaan luokalle kontroller tyyppi
public class AdminUserController {
	
	private static final Logger log = LoggerFactory.getLogger(DivelogApplication.class);

	@Autowired  //injektoi repositoryyn
	private AdminUserRepository repository; 
	
	// Show all admins
	// localhost:8080/adminuserlist
    @RequestMapping(value="/adminuserlist")
    public String userList(Model model) {
    	log.info("open adminuserlist");
    	model.addAttribute("admins", repository.findAll());
        return "adminuserlist";
    }
}
