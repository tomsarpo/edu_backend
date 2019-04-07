package fi.haagahelia.backend.divelog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
    public String index(){
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
