package IPL.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dao.ManagementDao;
import IPL.Dto.Management;

//@Controller
@RestController // it will do the work of controller and response body also 
public class Management_Controller {
	
	@Autowired
	ManagementDao managementDao;
	
	@RequestMapping("managementsignup")
	//@ResponseBody
	public ModelAndView save(@ModelAttribute Management management) {
		managementDao.saveManagement(management);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("msg","Management account got created");
		modelAndView.setViewName("index.jsp");
		
		return modelAndView;
	}
	@RequestMapping("managementlogin")
	//@ResponseBody
	public ModelAndView managementlogin(@RequestParam String username, @RequestParam String password) {
		Management management = managementDao.managementLogin(username);
		
		ModelAndView modelAndView = new ModelAndView();
		if (management== null) {
			modelAndView.addObject("msg", "Enetred invalid username");
			modelAndView.setViewName("managementlogin.jsp");
			
		}
		else {
			if(management.getPassword().equals(password)) {
				modelAndView.addObject("msg", "Management login success");
				modelAndView.setViewName("Managementhome.jsp");
			}
			else {
				modelAndView.addObject("msg", "Enetred invalid password");
				modelAndView.setViewName("managementlogin.jsp");
			}
		}
		return modelAndView;
		
	}
}
