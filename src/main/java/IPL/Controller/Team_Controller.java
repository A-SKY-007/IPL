package IPL.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dao.TeamDao;
import IPL.Dto.Team;

@RestController
public class Team_Controller 
{
	@Autowired
	TeamDao teamDao;
	
	@RequestMapping("teamsignup")
	public ModelAndView teamSignup(@ModelAttribute Team team) 
	{
		teamDao.teamSignup(team);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "Account got created");
		modelAndView.setViewName("index.jsp");
		
		return modelAndView;
		
	}
	@PostMapping("teamlogin")
	public ModelAndView teamLogin(@RequestParam String username,@RequestParam String password , HttpSession httpSession) 
	{
		Team team = teamDao.teamlogin(username);
		
		ModelAndView modelAndView = new ModelAndView();
		if(team==null) 
		{
			modelAndView.addObject("msg", "you have entered invalid username");
			modelAndView.setViewName("teamlogin.jsp");
		}
		else 
		{
			if(team.getPassword().equals(password)) {
				
				if(team.isStatus()) {
					httpSession.setAttribute("team", team); // here  we are setting the data by using session tracking for future use
					modelAndView.addObject("msg", "Login succesfull");
					modelAndView.setViewName("teamhome.jsp");
				}
				else {
					modelAndView.addObject("msg", "wait for management approval");
					modelAndView.setViewName("Managementhome.jsp");
				}

			}
			else {
				modelAndView.addObject("msg", "you have entered invalid password");
				modelAndView.setViewName("teamlogin.jsp");
			}
		}
		return modelAndView;
	}
	
	@RequestMapping("viewallteams")
	public ModelAndView viewAllTeams() 
	{
		List<Team> teams = teamDao.viewAllTeam();
		
		ModelAndView modelAndView = new ModelAndView();
		if(teams.isEmpty()) {
			modelAndView.addObject("msg", "No teams are available");
			modelAndView.setViewName("Managementhome.jsp");
		}
		else {
			modelAndView.addObject("teams",teams);
			modelAndView.setViewName("viewallteam.jsp");
		}
		return modelAndView;
	}
	
	@RequestMapping("changestatus")
	public ModelAndView changestatus(@RequestParam("id")int teamid) {
		
		Team team=teamDao.changeStatus(teamid);
		
		ModelAndView modelAndView=new ModelAndView();
		
		if (team.isStatus()) {
			team.setStatus(false);
		}
		else {
			team.setStatus(true);
		}
		
		teamDao.update(team);
		modelAndView.addObject("msg","Team status has been updated");
		modelAndView.setViewName("Managementhome.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("addammount")
	public ModelAndView addammount_for_the_team(@RequestParam double ammount, @RequestParam int id) {
		
		Team team=teamDao.addAmmount_for_team(id);
		
		team.setWallet(team.getWallet()+ammount);
		
		teamDao.update(team);
		
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("msg","ammount has been added successfully ");
		modelAndView.setViewName("Managementhome.jsp");
		
		return modelAndView;
	}
	
}
