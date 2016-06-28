package ttl.hibmvn;

import org.hibernate.Session;

import ttl.hibmvn.domain.User;
import ttl.hibmvn.utils.HibernateUtils;

public class MainApp {
	public static void main(String[] args) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		User user = new User("Joe", 20, 40);
		session.save(user);
		
		session.getTransaction().commit();
		
		//This will only work if you have a User in the DB with id 1.
		session.getTransaction().begin();
		User fromDB = (User)session.get(User.class, 1);
		System.out.println(fromDB);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtils.closeSessionFactory();
	}

}
