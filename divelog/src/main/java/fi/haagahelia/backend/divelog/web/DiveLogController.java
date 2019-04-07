package fi.haagahelia.backend.divelog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.backend.divelog.domain.DiveLogRepository;

@Controller //asetetaan luokalle kontroller tyyppi
public class DiveLogController {

	@Autowired  //injektoi repositoryyn
	private DiveLogRepository repository; 
	
	// Show all users
	// localhost:8080/diveslist
    @RequestMapping(value="/diveslist")
    public String userList(Model model, @RequestParam(defaultValue="0") int page) {	
    	// lisätään sivutustoiminto thymeleafiin
        model.addAttribute("dives", repository.findAll( PageRequest.of(page, 4)  ) );
        return "dives";
    }

}
