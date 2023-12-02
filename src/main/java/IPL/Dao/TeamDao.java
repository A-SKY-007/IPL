package IPL.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.Dto.Player;
import IPL.Dto.Team;

@Component
public class TeamDao 
{
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void teamSignup(Team team) 
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(team);
		entityTransaction.commit();
	}
	public Team teamlogin(String username) 
	{
		  EntityManager entityManager = entityManagerFactory.createEntityManager(); 
		  List<Team> list = entityManager.createQuery("select x from Team x where username=?1 ").setParameter(1, username).getResultList(); 
		  if(list.isEmpty()) {
			  return null;
		  }
		  else {
			  return list.get(0);
		  }
	}
	
	public List<Team> viewAllTeam() 
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Team> list = entityManager.createQuery("select x from Team x").getResultList();
		return list;
	}
	public Team viewPlayersOfRespectedTeam(int tid) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//List<Team> list = entityManager.createQuery("select x from Team x").getResultList();
		Team team = entityManager.find(Team.class, tid);
		return team;
	}
	
	public Team changeStatus(int teamid) {
		
		// TODO Auto-generated method stub
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				//List<Team> list = entityManager.createQuery("select x from Team x").getResultList();
				Team team = entityManager.find(Team.class, teamid);
				return team;
	}
	public void update(Team team) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(team);
		entityTransaction.commit();
	}
	
	public Team addAmmount_for_team(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//List<Team> list = entityManager.createQuery("select x from Team x").getResultList();
		Team team = entityManager.find(Team.class, id);
		return team;
	}
}
