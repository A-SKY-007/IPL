package IPL.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dao.PlayerDao;
import IPL.Dao.TeamDao;
import IPL.Dto.Player;
import IPL.Dto.Team;

@RestController
public class Player_Controller 
{ 
	// @Autowired 
	// Player player; 
	  
	 @Autowired 
	 PlayerDao playerDao; 
	 
	 @Autowired
	 TeamDao teamDao;
	  
	 @RequestMapping("playersignup") 
	 public ModelAndView playerSignUp(@ModelAttribute Player player)  
	 { 
	  player.setStatus("Pending"); 
	  playerDao.playerSignUp(player); 
	  ModelAndView modelAndView = new ModelAndView(); 
	  modelAndView.addObject("msg", "Player Account Created Successfully"); 
	  modelAndView.setViewName("index.jsp"); 
	  return modelAndView; 
	 } 
	  
	 @RequestMapping("playerlogin") 
	 public ModelAndView playerLogin(@RequestParam String username , @RequestParam String password, HttpSession httpSession)  
	 { 
	  Player player = playerDao.playerLogin(username); 
	  ModelAndView modelAndView = new ModelAndView(); 
	   
	  if(player==null) 
	  { 
	   modelAndView.addObject("msg" , "Invalid Player Name"); 
	   modelAndView.setViewName("playerlogin.jsp"); 
	   //return modelAndView; 
	  } 
	  else 
	  { 
		  httpSession.setAttribute("player",player);
	   if(player.getPassword().equals(password)) 
	   { 
	    modelAndView.addObject("msg" , "Login successfully"); 
	    modelAndView.setViewName("playerhomepage.jsp"); 
	   } 
	   else 
	   { 
	    modelAndView.addObject("msg" , "Invalid Player Password"); 
	    modelAndView.setViewName("playerlogin.jsp"); 
	   } 
	  } 
	  return modelAndView; 
	 }
	 @RequestMapping("editplayer")
	 public ModelAndView editPlayer(HttpSession httpSession) {
		Player player =  (Player) httpSession.getAttribute("player");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("player", player);
		modelAndView.setViewName("editplayer.jsp");
		return modelAndView;
	}
	 @RequestMapping("playerupdate")
	 public ModelAndView updatePlayer(@ModelAttribute Player player) {
		playerDao.playerUpdate(player);
		  ModelAndView modelAndView = new ModelAndView(); 
		  modelAndView.addObject("msg", "Player data has been updated Successfully");
		  modelAndView.setViewName("playerhomepage.jsp"); 
		  return modelAndView; 
	}
		@RequestMapping("viewplayers")
		public ModelAndView viewPlayers(@RequestParam ("id") int tid ) //data received in id from frontend and stored in tid
		{
			Team team = teamDao.viewPlayersOfRespectedTeam(tid);
			List<Player> players = team.getPlayers();
			
			ModelAndView modelAndView =  new ModelAndView();
			if(players.isEmpty()) {
				modelAndView.addObject("msg","No players are available inside "+team.getName());
				modelAndView.setViewName("viewteamplayers.jsp");
			}
			else {
				modelAndView.addObject("players",players);
				modelAndView.addObject("msg",team.getName());
				modelAndView.setViewName("viewteamplayers.jsp");
			}
			return modelAndView;
		}
		
		@RequestMapping("viewallplayers")
		public ModelAndView view_all_player_comming_for_Auction() {
			
			List<Player> players=playerDao.view_all_player_comming_for_Auction();
			ModelAndView modelAndView=new ModelAndView();
			
			if(players.isEmpty()) {
				modelAndView.addObject("msg","No players are available");
				modelAndView.setViewName("Managementhome.jsp");
			}
			else {
				modelAndView.addObject("players",players);
				modelAndView.setViewName("viewallplayers.jsp");
			}
			return modelAndView;
		}
		@RequestMapping("changeplayerstatus")
		public ModelAndView changeplayerstatus(@RequestParam int id) {
			Player player=playerDao.changeplayerstatus(id);
			if(player.getStatus().equals("pending")) {
				player.setStatus("available");
			}
			else {
				player.setStatus("pending");
			}
			playerDao.playerUpdate(player);
			
			List<Player> players=playerDao.view_all_player_comming_for_Auction();
			
			ModelAndView modelAndView=new ModelAndView();
			
			modelAndView.addObject("msg","status has been updated.");
			modelAndView.addObject("players",players);
			modelAndView.setViewName("viewallplayers.jsp");
			
			return modelAndView;
		}
		
		@RequestMapping("viewavailableplayers")
		public ModelAndView viewavailableplayer(HttpSession httpSession) {
			
			Team team=(Team) httpSession.getAttribute("team");
			
			
			//changes from here.
			
			List<Player> players=playerDao.viewavailableplayer();
			ModelAndView modelAndView=new ModelAndView();
			if(players.isEmpty()) {
				modelAndView.addObject("msg","Currently no Active player are available");
				modelAndView.setViewName("viewactiveplayer.jsp");
			}
			else {
			modelAndView.addObject("players",players);
			modelAndView.setViewName("viewactiveplayer.jsp");
			}
			return modelAndView;
			
		}
	}
