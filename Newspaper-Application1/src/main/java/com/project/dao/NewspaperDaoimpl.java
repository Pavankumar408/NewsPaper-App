package com.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Newspaper;
@Component
public class NewspaperDaoimpl  implements NewspaperDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	
	public NewspaperDaoimpl() {
		System.out.println("object is created:"+this.getClass().getName());
	}

	@Override
	public boolean saveNewspaperEntity(Newspaper newspaper) {
		System.out.println("involked saveNewspaperEntity ");
		Session session=null;
		try {
			session=sessionfactory.openSession();
			session.beginTransaction();
			session.save(newspaper);
			session.getTransaction().commit();
			return true;
		}
		catch(HibernateException e){
			System.out.println(e.getMessage());
			
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}

	
	

	

	@Override
	public List<Newspaper> getAllNewspaperDetails() {
		System.out.println("NewspaperDaoimpl.getAllNewspaperDetails()");
		Session session=null;
		try {
			session=sessionfactory.openSession();
			Query query=session.createNamedQuery("NewspaperObject2");
			List<Newspaper> list=query.list();
			if(list!=null&&!list.isEmpty()) {
				return list;
			}
			else {
				System.out.println("list is empty ,,,,add some data");
				
			}
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
			}
		return null;
	
	}

	@Override
	public boolean deleteNewspaperEntity(String newspapername) {
	System.out.println("NewspaperDaoimpl.deleteNewspaperEntity()");
	Session session=null;
	try {
		session=sessionfactory.openSession();
		Query query=session.createNamedQuery("NewspaperObject3");
		query.setParameter("Newspapername", newspapername);
	Newspaper object=(Newspaper) query.uniqueResult();
	session.beginTransaction();
	session.delete(object);
	session.getTransaction().commit();
	System.out.println("Newspaper details is deleted sucessfully");
	return true;
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
		session.getTransaction().rollback();
	}
	finally {
		if(session!=null) {
			session.close();
			System.out.println("session is closed");
		}
		else {
			System.out.println("session is not closed");
		}
		}
		return false;
	}

	@Override
	public Newspaper searchNewspaper(String newspapername) {
	System.out.println("NewspaperDaoimpl.searchNewspaper()");
	Session session=null;
	try {
		session=sessionfactory.openSession();
		Query query=session.createNamedQuery("NewspaperObject");
		query.setParameter("Newspapername", newspapername);
		Newspaper paper=(Newspaper) query.uniqueResult();
		if(paper!=null) {
			return paper;
		}
		else {
			System.out.println("Newspaper Details are not found");
		}
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	finally {
		if(session!=null) {
			session.close();
			System.out.println("session is closed");
		}
		else {
			System.out.println("session is not closed");
		}
		
	}
	return null;
	
	}}
