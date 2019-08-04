package com.test.testCrud.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.testCrud.springdemo.entity.Companies;


@Repository
public class CompaniesDAOImpl implements CompaniesDAO {

	
	
	
	
	
	
	private EntityManager entityManager;
	
	@Autowired
	public  CompaniesDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	
	@Override
	public List<Companies> getCompanies() {
		
		//get the current hibernate session
		 
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query.. sort by last name(by updating HQL)
		
		Query<Companies> theQuery = currentSession.createQuery("from Companies",
				Companies.class);
		
		//execute query and get result list
		
		List<Companies> companies = theQuery.getResultList();
		
		//return the result
	
	return companies;
	}

	@Override
	public void saveCompanies(Companies theCompanies) {
		
		//get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save/update the customer.. finally
		currentSession.saveOrUpdate(theCompanies);
		
	}

	@Override
	public Companies getCompanies(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//now retrieve/read from database using primary key
		Companies theCompanies = currentSession.get(Companies.class,theId);
	
		
		return theCompanies;
	}

	@Override
	public void deleteCompanies(int theId) {
		
		//get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete the object with primary key
		
		Query theQuery =
				currentSession.createQuery("delete from Companies where id=:companyId");
		
		theQuery.setParameter("companyId", theId);
	
	theQuery.executeUpdate();
	}

}
