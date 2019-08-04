package com.test.testCrud.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.testCrud.springdemo.entity.Companies;

import com.test.testCrud.springdemo.service.CompaniesService;


@Controller
@RequestMapping("/companies")
public class CompaniesController {

	
	//need to inject customer service
	@Autowired
	private CompaniesService companiesService;
	
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
	
		//get customers from service
		List<Companies> theCompanies = companiesService.getCompanies();
		
		//add the customers to the model
		theModel.addAttribute("companies", theCompanies);
		
		
		return "companies";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Companies theCompanies = new Companies();
		
		theModel.addAttribute("companies",theCompanies);
		
		return "update";
	}
	
	
	@PostMapping("/saveCompanies")
	public String saveCompanies(@ModelAttribute("companies") Companies theCompanies) {
		
		//save the customer using our service
		companiesService.saveCompanies(theCompanies);
	
		
		return "redirect:/companies/list";
	}
	
	
	
	
	

	

	@GetMapping("/showFormForUpdate/{companiesId}")
     public String showFormForUpdate(@PathVariable("companiesId") int theId, 
			                         Model theModel) {
		
		//get the customer from our service
		
		Companies theCompanies = companiesService.getCompanies(theId);
		
		//set customer as model attribute to pre-populate the form
		
		theModel.addAttribute("companies", theCompanies);
		
		//send over to our form
		
		return "update.html";
		
	}

	
	
	

	
	


	
	
	
	@GetMapping("/delete/{companiesId}")
	public String deleteCustomer(@PathVariable("companiesId") int theId) {
		
		
		//delete the customer
		companiesService.deleteCompanies(theId);
		
		return "redirect:/companies/list";
	}
	
	
}
