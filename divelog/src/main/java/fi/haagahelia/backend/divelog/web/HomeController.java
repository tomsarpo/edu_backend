package fi.haagahelia.backend.divelog.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //asetetaan luokalle kontroller tyyppi
public class HomeController {
	
	private String appMode;

    @Autowired
    public HomeController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }
    
	@RequestMapping(value = "/")
    public String index(Model model){
		
		//set user info to model
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Tomi");
        model.addAttribute("mode", appMode);
        
        return "main";
    } 
	
	@PostMapping(value="/login")
    public String login() {	
        //return "login";
        return "redirect:/main";
    }
	
	@PostMapping(value="/browser")
    public String browser() {	
        //return "login";
        return "redirect:/browser/index.html#/";
    }

}
