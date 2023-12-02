package IPL.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dto.Management;
import IPL.Dto.Player;
import IPL.Dto.Team;

//@org.springframework.stereotype.Controller
@RestController
public class Controller 
{
	
	@Autowired //it will act like vehicle and it will bring the object from the respective class.
	Management management;
	
	@Autowired
	Player player;
	
	@Autowired
	Team team;
	
	@RequestMapping("signup")
	//@ResponseBody
	public ModelAndView signup(@RequestParam String role) 
	{
		ModelAndView modelAndView = new ModelAndView(); //here ModelAndView model means object view means front end(jsp) here the work of ModelAndView is nothing but carrying the object to the front end(to the jsp).
		
		
		if(role.equals("Management")) {
			modelAndView.addObject("management",management);
			modelAndView.setViewName("managementsignup.jsp");
			 
		}
		else if (role.equals("player")) {
			modelAndView.addObject("player",player);
			modelAndView.setViewName("playersignup.jsp");
		}
		else{
			modelAndView.addObject("team",team);
			modelAndView.setViewName("teamsignup.jsp");
		}
		return modelAndView; //if I want to carry any thing to the front end I should return the reference variable to  the ModelAndView object.
	}
}
