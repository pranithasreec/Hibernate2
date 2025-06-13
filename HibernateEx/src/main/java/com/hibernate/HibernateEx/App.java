package com.hibernate.HibernateEx;
import java.util.jar.Attributes.Name;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
	
	SessionFactory  sessionFactory;  // interface
	
	Session  session;
	// default
	public App() {
		sessionFactory= new Configuration().configure("hibernate.config.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    	
	}
	void insert()
	{
		session=sessionFactory.openSession();
    	Transaction txTransaction= session.beginTransaction();
    	
    	Student s= new Student();
    	s.setRollno(106);
    	s.setName("Shyam");
    	s.setMarks(10000.0);
    	
    	session.save(s);
    	txTransaction.commit();
	}	
	void search(int rollno) {
		session=sessionFactory.openSession();
		Student rs = session.get(Student.class, rollno);
		if(rs!= null) {
			System.out.println(rs.toString());
		}
		else {
			System.out.println("Not found");
		}
	}
	
//	void searchByName(int rollno) {
//		session=sessionFactory.openSession();
//		Student sr = session.find(Student.class, rollno);
//		if(sr!= null) {
//			System.out.println(sr.toString());
//		}
//		else {
//			System.out.println("Not found");
//		}
//	}
	
	void removeByRollNo(int rno) {
		session=sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		Student r=session.find(Student.class, rno);
    	if(r==null)
    	{
    		System.out.println("Not Found");
    	}
    	else {
    	session.delete(r);
    	System.out.println("Found");
    	
    		}
    		
    	txTransaction.commit();
		
	}
	void updateNameFee(int roll,double marks,String name)
	{
		
		session=sessionFactory.openSession();
    	Transaction txTransaction= session.beginTransaction();
    	
    	Student s= new Student();
    	s.setRollno(104);
    	s.setName(name);
    	s.setMarks(marks);
    	
    	session.update(s);
    	
    	txTransaction.commit();
 
    	
	}
	void updateStudentMarksByRollNo(int rollno, double newMarks) {
	    session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();

	    Student s = session.get(Student.class, rollno);

	    if (s!= null) {
	        s.setMarks(newMarks);
	        session.update(s);
	        transaction.commit();
	        System.out.println("Marks updated : " + rollno);
	    } else {
	        System.out.println("Not Found");
	        transaction.rollback();
	    }

	    session.close();
	}

    public static void main( String[] args){
    	App obj= new App();
    	
//       obj.search(220);
//    	 obj.searchByName(105);
//    	obj.removeByRollNo(102);
//    	obj.updateNameFee(104, 89.90,"Sree");
    	obj.updateStudentMarksByRollNo(104,2100);
    	System.out.println( "Done !" );

    }
}
//
//import java.util.jar.Attributes.Name;
//import org.hibernate.cfg.Configuration;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
///**
// * Hello world!
// *
// */
//public class App
//{
//	
//	SessionFactory  sessionFactory;  // interface
//	
//	Session  session;
//
//public App() 
//{
//		
//sessionFactory= new Configuration().configure("hiber.config.xml").addAnnotatedClass(Student.class).buildSessionFactory();
//    	
//    	session=sessionFactory.openSession();
//	}
//	void insert()
//	{
//		
//    	Transaction txTransaction= session.beginTransaction();
//    	
//    	Student s= new Student();
//    	s.setRollno(107);
//    	s.setName("ajay");
//    	s.setMarks(10000.0);
//    	
//    	session.save(s);
//    	txTransaction.commit();
//	}
//	void search(int rollno)
//	{
//		
//    	session=sessionFactory.openSession();
//    Student rs=	session.get(Student.class, rollno);
//    if(rs!=null)
//    {
//    	System.out.println(rs.toString());
//    }
//    else {
//    	System.out.println("Not Found");
//	}
//	}
//    void searchByName(String name)
//	{
//		
//		session=sessionFactory.openSession();
//		Student sr=session.find(Student.class, name);
//		 if(sr!=null)
//		    {
//		    	System.out.println(sr.toString());
//		    }
//		    else {
//		    	System.out.println("Not Found");
// 
//		    	
//			}
//	}	
////    void searchByName(String name)
////	{
////		
////		session=sessionFactory.openSession();
////		Student sr=session.find(Student.class, name);
////		 if(sr!=null)
////		    {
////		    	System.out.println(sr.toString());
////		    }
////		    else {
////		    	System.out.println("Not Found");
////		    	
////			}
////	}
//    
//    void removeByRollNo(int rno) {
//    	session=sessionFactory.openSession();
//    	Transaction txTransaction= session.beginTransaction();
//    	Student r=session.find(Student.class,rno);
//    	if(r==null) {
//    		System.out.println("Not Found");
//    	}
//    	else
//    	{
//    		session.delete(r);
//    		
//    	}
//    	
//    }
//    public static void main( String[] args )
//    {
//    	   	
//    	App obj= new App();
//    	obj.removeByRollNo(102);
////      obj.insert();
////	obj.search(1099);
//    	
//    	
//    	// IN THE INTERFACE CONTAINS THE TOOLS OF THE DATABASES
//    	// SESSION IS WHEN STUDENT AND TABLE ARE TWO ENTITIES , SESSION WOULD MAP MY ENTITY IN BACKEND
//    	// STU ENTITY AND POM HAS THE REQUIRED DATA AND THE SESSION WOULD MAP THE DATA USING SESSION FACTORY
//    	//
////    	SessionFactory sessionFactory;
////    	Session session;
////    	sessionFactory=new Configuration().configure("hibernate.config.xml").addAnnotatedClass(Student.class).buildSessionFactory();
////    	session=sessionFactory.openSession();
////    	Transaction txTransaction=session.beginTransaction();
////    	Student s=new Student();
////    	s.setRollno(104);
////    	s.setName("Janu");
////    	s.setMarks(4000.0);
////    	session.save(s);
////    	txTransaction.commit();
////        System.out.println( "Done !" );
//        
//    
//
//    }
//}
