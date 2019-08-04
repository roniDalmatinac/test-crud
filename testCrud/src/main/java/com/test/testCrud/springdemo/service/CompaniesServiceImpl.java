package com.test.testCrud.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.testCrud.springdemo.dao.CompaniesDAO;

import com.test.testCrud.springdemo.entity.Companies;



@Service
public class CompaniesServiceImpl implements CompaniesService {

	
	//need to inject customerDAO
	
	@Autowired
	private CompaniesDAO companiesDAO;
	
	
	@Override
	@Transactional
	public List<Companies> getCompanies() {
			return companiesDAO.getCompanies();
	}


	@Override
	@Transactional
	public void saveCompanies(Companies theCompanies) {
		
		
		companiesDAO.saveCompanies(theCompanies);
		
	}


    @Override
	@Transactional
	public Companies getCompanies(int theId) {
		
		return companiesDAO.getCompanies(theId);
	}


	@Override
	@Transactional
	public void deleteCompanies(int theId) {
		
		companiesDAO.deleteCompanies(theId);
		
	}

}
