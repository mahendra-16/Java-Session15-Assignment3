package com.mvc.webapp;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String viewlogin(Model model){
		User user = new User();
		model.addAttribute("User", user);
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String showsuccess(@Valid @ModelAttribute("User") User user, BindingResult result){
		if(result.hasErrors()){
			return "login";
		}else{
			System.out.println("User value is : " + user);
			return "success";
		}
	}
	
}
