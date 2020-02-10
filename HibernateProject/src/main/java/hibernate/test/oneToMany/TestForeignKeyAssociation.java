package hibernate.test.oneToMany;

import hibernate.test.HibernateUtil;
import hibernate.test.oneToMany.foreignKeyAsso.AccountEntity;
import hibernate.test.oneToMany.foreignKeyAsso.EmployeeEntity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class TestForeignKeyAssociation
{
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		
		AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("123-345-65454");
		
		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("123-345-6542222");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");
		
		Set<AccountEntity> accounts = new HashSet<AccountEntity>();
		accounts.add(account1);
		accounts.add(account2);
		
		emp.setAccounts(accounts);
		//Save Employee
		session.save(emp);
		
		
		/*AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("Account detail 1");
		
		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("Account detail 2");
		
		AccountEntity account3 = new AccountEntity();
		account3.setAccountNumber("Account detail 3");
		
		//Add new Employee object
		EmployeeEntity firstEmployee = new EmployeeEntity();
		firstEmployee.setEmail("demo-user-first@mail.com");
		firstEmployee.setFirstName("demo-one");
		firstEmployee.setLastName("user-one");
		
		EmployeeEntity secondEmployee = new EmployeeEntity();
		secondEmployee.setEmail("demo-user-second@mail.com");
		secondEmployee.setFirstName("demo-two");
		secondEmployee.setLastName("user-two");
		
		Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
		accountsOfFirstEmployee.add(account1);
		accountsOfFirstEmployee.add(account2);
		
		Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
		accountsOfSecondEmployee.add(account3);
		
		firstEmployee.setAccounts(accountsOfFirstEmployee);
		secondEmployee.setAccounts(accountsOfSecondEmployee);
		//Save Employee
		session.save(firstEmployee);
		session.save(secondEmployee);
		*/
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
