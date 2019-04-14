package fi.haagahelia.backend.divelog.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.backend.divelog.DivelogApplication;
import fi.haagahelia.backend.divelog.domain.DiveLog;
import fi.haagahelia.backend.divelog.domain.DiveLogRepository;

@Controller //asetetaan luokalle kontroller tyyppi
public class DiveLogController {
	
	private static final Logger log = LoggerFactory.getLogger(DivelogApplication.class);

	@Autowired  //injektoi repositoryyn
	private DiveLogRepository repository; 
	
//	@Override
//    public Page<DiveLog> findAll(Pageable pageable) {
//        Page<DiveLog> diveList = DiveLogRepository.findAll(pageable);
//        return diveList;
//    }
	
	// Show all users
	// localhost:8080/diveslist
    @RequestMapping(value="/divelist")
    public String diveList(Model model, @RequestParam(defaultValue="0") int page) {	
        model.addAttribute("dives", repository.findAll() );
    	// lisätään sivutustoiminto thymeleafiin
        //model.addAttribute("dives", repository.findAll( PageRequest.of(page, 4)  ) );
        return "divelist";
    }
    
    @RequestMapping(value = "/add_dive")
    public String add(Model model){
    	model.addAttribute("dive", new DiveLog());
        return "add_dive";
    }     
    
    //käytetään add_.html templatessa
    @RequestMapping(value = "/save_dive", method = RequestMethod.POST)
    public String save(@Valid DiveLog dive, BindingResult bindingResult, Model model){ //validation of new user input
    	if (bindingResult.hasErrors()) {
    		log.info("error@bindingResult: " + bindingResult );
    		//model.addAttribute("bindingResult", bindingResult.toString() );
        	return "/error";
        }
    	
    	repository.save(dive);
        return "redirect:/divelist";
    }
   

    @RequestMapping(value = "/delete_dive/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:/divelist";
    }

}
