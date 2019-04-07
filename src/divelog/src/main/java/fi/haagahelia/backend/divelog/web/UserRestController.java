package fi.haagahelia.backend.divelog.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.backend.divelog.domain.User;
import fi.haagahelia.backend.divelog.domain.UserRepository;

@Controller //asetetaan luokalle kontroller tyyppi
public class UserRestController {
	@Autowired  //injektoi repositoryyn
	private UserRepository repository; 
	
	// localhost:8080/api antaa listan REST kutsuista joita on saatavilla
	
    /* ei ole pakollinen, koska REST boot tekee tämän automaattisesti
    // RESTful service to get all students
	// localhost:8080/api/students
    @RequestMapping(value="/students", method = RequestMethod.GET)
    public @ResponseBody List<Student> studentListRest() {	//RestController palauttaa HTTPResponsen ja JSON dataa
        return (List<Student>) repository.findAll();
    }  
    */  

	// RESTful service to get student by id
 	// localhost:8080/api/students/4
    @RequestMapping(value="/userlist_api/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<User> findStudentRest(@PathVariable("id") Long userId) {	
    	return repository.findById(userId);
    }    
}
