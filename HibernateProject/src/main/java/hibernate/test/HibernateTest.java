package hibernate.test;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.test.oneToMany.foreignKeyAsso.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory  sessionFactory =(SessionFactory) new Configuration().configure(new File("C:\\Users\\ashis\\git\\Hibernate\\HibernateProject\\hibernate.cfg.xml")).buildSessionFactory();
       
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails u1=new UserDetails(01, "Ashish");
		
		UserDetails u2=new UserDetails(02, "Ravi");
		session.save(u1);
		session.save(u2);
		session.getTransaction().commit();
		session.close();
		
	}

}
