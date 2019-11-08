package com.springboot.employee.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.springboot.employee.beans.Address;
import com.springboot.employee.beans.Employee;

public class GeneratorEmployeeList {

	public static List<Employee> generateEmployeeList() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setEmpID((long) 7373);
		emp1.setEmpFirstName("RAM");
		emp1.setEmpLastName("NARESH");
		emp1.setEmpDesignation("SSE");
		emp1.setEmpSalary(179.79);
		List<Address> address = new ArrayList<Address>();
		Address add1 = new Address();
		add1.setAddressName("23Street");
		add1.setLocation("Kerala");
		add1.setCity("Quilon");
		Address add2 = new Address();
		add2.setAddressName("25Street");
		add2.setLocation("Kerala1");
		add2.setCity("Quilon1");
		address.add(add1);
		address.add(add2);
		emp1.setAddress(address);
		
		Employee emp2 = new Employee();
		emp2.setEmpID((long) 7372);
		emp2.setEmpFirstName("RAMESH");
		emp2.setEmpLastName("NARESH");
		emp2.setEmpDesignation("SSE");
		emp2.setEmpSalary(179.79);
		List<Address> address2 = new ArrayList<Address>();
		Address add3 = new Address();
		add3.setAddressName("24Street");
		add3.setLocation("Kerala1");
		add3.setCity("Quilon1");
		Address add4 = new Address();
		add4.setAddressName("25Street");
		add4.setLocation("Kerala2");
		add4.setCity("Quilon1");
		address2.add(add3);
		address2.add(add4);
		emp2.setAddress(address2);
		
		/*Employee emp3 = new Employee();
		emp3.setEmpID((long) 7371);
		emp3.setEmpFirstName("RAMESH");
		emp3.setEmpLastName("CHANDRAN");
		emp3.setEmpDesignation("SSE");
		emp3.setEmpSalary(179.79);
		List<Address> address3 = new ArrayList<Address>();
		Address add3 = new Address();
		add3.setAddressName("25Street");
		add3.setLocation("Kerala2");
		add3.setCity("Quilon2");
		address3.add(add3);
		emp3.setAddress(address3);
		
		Employee emp4 = new Employee();
		emp4.setEmpID((long) 7375);
		emp4.setEmpFirstName("RAMESH");
		emp4.setEmpLastName("CHANDRAN");
		emp4.setEmpDesignation("SSE");
		emp4.setEmpSalary(179.79);
		List<Address> address4 = new ArrayList<Address>();
		Address add4 = new Address();
		add4.setAddressName("26Street");
		add4.setLocation("Kerala3");
		add4.setCity("Quilon3");
		address4.add(add4);
		emp4.setAddress(address4);*/
		
		employees.add(emp1);
		employees.add(emp2);
		return employees;
	}

}
