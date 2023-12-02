package IPL.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.Dto.Player;

@Component
public class PlayerDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void playerSignUp(Player player) 
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();
	}
	
	public Player playerLogin( String username  )  
	{ 
	  EntityManager entityManager = entityManagerFactory.createEntityManager(); 
	  List<Player> list = entityManager.createQuery("select x from Player x where username=?1 ").setParameter(1, username).getResultList(); 
	  if(list.isEmpty()) {
		  return null;
	  }
	  else {
		  return list.get(0);
	  }
	
	}
	
	public void playerUpdate(Player player) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(player);
		entityTransaction.commit();
	}
	
	public List<Player> view_all_player_comming_for_Auction() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Player> list=entityManager.createQuery("select x from Player x").getResultList();
		return list;
	}
	
	public Player changeplayerstatus(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Player player=entityManager.find(Player.class, id);
		return player;
	}
	//change from here
	public List<Player> viewavailableplayer() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Player> list=entityManager.createQuery("select x from Player x where x.status in('available')").getResultList();
		return list;
	}
}
