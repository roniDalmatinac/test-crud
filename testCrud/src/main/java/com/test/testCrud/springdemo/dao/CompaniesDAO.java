package com.test.testCrud.springdemo.dao;

import java.util.List;

import com.test.testCrud.springdemo.entity.Companies;


public interface CompaniesDAO {

	
	public List<Companies> getCompanies();

	public void saveCompanies(Companies theCompanies);

	public Companies getCompanies(int theId);

	public void deleteCompanies(int theId);


}
