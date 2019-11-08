package com.springboot.employee;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.springboot.employee.beans.Employee;


public class EmployeeProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Collection<Employee> employees = EmployeeProcessor.processEmployees(exchange);
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
		StringBuilder csv = new StringBuilder();
		csv.append("EmployeeID,").append("EmpFirstName,").append("EmpLastName,").append("EmployeeDesignation,")
				.append("EmpSalary");
		csv.append("\n").toString();
	}

	@SuppressWarnings("unchecked")
	public static Collection<Employee> processEmployees(Exchange ex) {

		Collection<Employee> employees = new ArrayList<Employee>();
		if (ex.getIn().getBody() != null) {
			if (ex.getIn().getBody().getClass().isAssignableFrom(Employee.class)) {

				employees.add((Employee) ex.getIn().getBody());
			} else {
				employees = (Collection<Employee>) ex.getIn().getBody();
			}
		}
		return employees;
	}
}
