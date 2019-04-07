package fi.haagahelia.backend.course.excercise1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class HelloController {
	//@RequestMapping("*")
	@RequestMapping("/hello")
	
	//http://localhost:8080/hello?nimi=John;sijainti=England
	public String hello(@RequestParam(name="nimi") String name ,
			@RequestParam(name="sijainti", required=false) String location) {
		return "Hello " + name + ". Sijaintisi on " + location;
	}
	
}
