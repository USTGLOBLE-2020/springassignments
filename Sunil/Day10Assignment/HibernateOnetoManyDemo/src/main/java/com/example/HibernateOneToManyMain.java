package com.example;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Cart;
import com.model.Items;

public class HibernateOneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setName("MyCart");

		Items item1 = new Items("I10", 10, 1, cart);
		Items item2 = new Items("I20", 20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); itemsSet.add(item2);

		cart.setItems(itemsSet);
		cart.setTotal(10*1 + 20*2);

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			//Get Session
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			//start transaction
			tx = session.beginTransaction();
			System.out.println("begin");
			//Save the Model object
			session.save(cart);
			session.save(item1);
			session.save(item2);
			//Commit transaction
			System.out.println("before save");
			tx.commit();
			System.out.println("Cart1 ID="+cart.getId());
			System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart().getId());
			System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart().getId());

		}catch(Exception e){
			tx.rollback();
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}

