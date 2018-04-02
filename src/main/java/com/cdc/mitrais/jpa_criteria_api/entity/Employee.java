package com.cdc.mitrais.jpa_criteria_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;
	private String ename;
	private double salary;
	private String deg;
	
	public Employee() {}
	
	public Employee(int eid, String ename, double salary, String deg) {
		this.setEid(eid);
		this.setEname(ename);
		this.setSalary(salary);
		this.setDeg(deg);
	}

	public String toString() {
		return "Employee [eid = "+eid+", ename = "+ename+", salary = "+salary+", deg = "+deg+"]";
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}
	
	
}
