package com.test.testCrud.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_table")
public class Companies {

	//fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="founded")
	private int founded;
	
	
	//constructor
	
	public Companies() {
		
	}


	public Companies(String company_name, String city, int founded) {
		this.company_name = company_name;
		this.city = city;
		this.founded = founded;
	}

	//getter/setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getFounded() {
		return founded;
	}


	public void setFounded(int founded) {
		this.founded = founded;
	}

	
	//toString
	@Override
	public String toString() {
		return "Companies [id=" + id + ", company_name=" + company_name + ", city=" + city + ", founded=" + founded
				+ "]";
	}
	
	
	
	

	
	
	

	
	
	
}
