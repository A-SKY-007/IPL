package IPL.Dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.Dto.Management;

@Component
public class ManagementDao {

		@Autowired
		EntityManagerFactory entityManagerFactory;
		
		public void saveManagement(Management management) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			entityManager.persist(management);
			entityTransaction.commit();
		}
		
		public Management managementLogin(String username) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			Query query =  entityManager.createQuery("select x from Management x where username=?1").setParameter(1, username);
//			
//			List<Management> list = query.getResultList(); 
			
			List<Management> list = entityManager.createQuery("select x from Management x where username=?1").setParameter(1, username).getResultList();
			
			if(list.isEmpty()) {
				return null;
			}
			else {
				return list.get(0);
			}
		}
}
