package com.test.testCrud.springdemo.service;

import java.util.List;

import com.test.testCrud.springdemo.entity.Companies;



public interface CompaniesService {

	
	public List<Companies> getCompanies();

	public void saveCompanies(Companies theCompanies);

	

    public	Companies getCompanies(int theId);

	public void deleteCompanies(int theId);
}
