package fi.haagahelia.backend.divelog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.backend.divelog.domain.UserRepository;

public class UserController {
	
	@Autowired  //injektoi repositoryyn
	private UserRepository repository; 
	
	// Show all users
    @RequestMapping(value="/userlist")
    public String userList(Model model) {	
        model.addAttribute("users", repository.findAll());
        return "userlist";
    }

}
