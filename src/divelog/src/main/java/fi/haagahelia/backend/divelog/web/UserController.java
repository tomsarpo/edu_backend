package fi.haagahelia.backend.divelog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.backend.divelog.DivelogApplication;
import fi.haagahelia.backend.divelog.domain.DiveLog;
import fi.haagahelia.backend.divelog.domain.User;
import fi.haagahelia.backend.divelog.domain.UserRepository;

@Controller //asetetaan luokalle kontroller tyyppi
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(DivelogApplication.class);

	@Autowired  //injektoi repositoryyn
	private UserRepository repository; 
	
	// Show all users
	// localhost:8080/userlist
    @RequestMapping(value="/userlist")
    public String userList(Model model, @RequestParam(defaultValue="0") int page) {	
    	log.info("open userlist");
    	//model.addAttribute("users", repository.findAll() );
    	// lisätään sivutustoiminto thymeleafiin
        model.addAttribute("users", repository.findAll( PageRequest.of(page, 4)  ) );
        log.info("model: " + model.toString() );
        return "userlist";
    }
    
    @RequestMapping(value = "/add_user")
    public String add(Model model){
    	model.addAttribute("user", new User());
        return "add_user";
    }     
    
    //käytetään add_.html templatessa
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public String save(User user){
        repository.save(user);
        return "redirect:/userlist";
    }    

    @RequestMapping(value = "/delete_user/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:/userlist";
    }

}
