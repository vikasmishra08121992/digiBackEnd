package com.candidjava.spring.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Department")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptID;

	@Column(name = "deptName")
	private String deptName;

	public long getDeptID() {
		return deptID;
	}

	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
