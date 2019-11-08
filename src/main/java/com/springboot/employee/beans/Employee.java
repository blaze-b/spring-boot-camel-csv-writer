package com.springboot.employee.beans;

import java.util.List;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;
import org.apache.camel.dataformat.bindy.annotation.OneToMany;

@CsvRecord(separator = ",",skipFirstLine = true,generateHeaderColumns = true)
public class Employee {

	@DataField(columnName = "EmployeeID",pos = 1, required = true, trim = true)
	private Long empID;

	@DataField(columnName = "EmpFirstName", pos = 2, required = true, trim = true)
	private String empFirstName;

	@DataField(columnName = "EmpLastName", pos = 3, required = true, trim = true)
	private String empLastName;

	@DataField(columnName = "EmployeeDesignation", pos = 4, required = false)
	private String empDesignation;

	@DataField(columnName = "EmpSalary",pos = 5)
	private Double empSalary;
   
	//@Link
	@OneToMany(mappedTo = "com.springboot.employee.Address")
	private List<Address> address;
	
	public Long getEmpID() {
		return empID;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpID(Long empID) {
		this.empID = empID;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empDesignation=" + empDesignation + ", empSalary=" + empSalary + ", address=" + address + "]";
	}

	
}
