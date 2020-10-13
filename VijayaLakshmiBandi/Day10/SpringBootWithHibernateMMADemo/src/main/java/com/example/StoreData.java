package com.example;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.Answer;
import com.model.Question;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();    
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();    
		SessionFactory factory=meta.getSessionFactoryBuilder().build();    
		Session session=factory.openSession();    
		Transaction t=session.beginTransaction();      

		Answer an1=new Answer();  
		an1.setAnswername("Java");  
		an1.setPostedBy("James");  

		Answer an2=new Answer();  
		an2.setAnswername("C");  
		an2.setPostedBy("BalaSubramanyam");  

		Question q1=new Question();  
		q1.setQname("What are the programming languages?");  
		ArrayList<Answer> l1=new ArrayList<Answer>();  
		l1.add(an1);  
		l1.add(an2);  
		q1.setAnswers(l1);  


		Answer ans3=new Answer();    
		ans3.setAnswername("Class");    
		ans3.setPostedBy("Object");    

		Answer ans4=new Answer();    
		ans4.setAnswername("Structure");    
		ans4.setPostedBy("Enum");    

		Question q2=new Question();  
		q2.setQname("What are the basics of building blocks?");  
		ArrayList<Answer> l2=new ArrayList<Answer>();  
		l2.add(ans3);  
		l2.add(ans4);  
		q2.setAnswers(l2);  

		session.persist(q1);    
		session.persist(q2);    

		t.commit();    
		session.close();    
		System.out.println("success");   
	}

}
