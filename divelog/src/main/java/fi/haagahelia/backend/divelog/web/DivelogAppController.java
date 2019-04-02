package fi.haagahelia.backend.divelog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DivelogAppController {
	
	@RequestMapping(value = "/")
    public String index(){
        return "index";
    } 
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

}
