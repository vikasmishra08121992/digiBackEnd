package com.candidjava.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Account")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="empId")
	private long empId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="salary")
	private long salary;
}
