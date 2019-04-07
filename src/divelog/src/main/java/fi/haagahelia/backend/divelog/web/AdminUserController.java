package fi.haagahelia.backend.divelog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.backend.divelog.DivelogApplication;
import fi.haagahelia.backend.divelog.domain.AdminUser;
import fi.haagahelia.backend.divelog.domain.AdminUserRepository;
import fi.haagahelia.backend.divelog.domain.User;

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
    
    @RequestMapping(value = "/add_admin")
    public String add(Model model){
    	model.addAttribute("admin", new AdminUser());
        return "add_user";
    }     
    
    //käytetään add_.html templatessa
    @RequestMapping(value = "/save_admin", method = RequestMethod.POST)
    public String save(AdminUser auser){
        repository.save(auser);
        return "redirect:/adminuserlist";
    }    

    @RequestMapping(value = "/delete_admin/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:/adminuserlist";
    }
}
