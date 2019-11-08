package com.springboot.employee;


import java.util.List;
import com.springboot.employee.util.GeneratorEmployeeList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springboot.employee.beans.Employee;

@Component
public class EmployeCSVRoute extends RouteBuilder {
	
	@Autowired
	private ProducerTemplate producerTemplate;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		final CsvDataFormat csvDataFormat = new CsvDataFormat();
		csvDataFormat.setHeaderDisabled(false);

		System.out.println("Entering----PurchaseOrderComponent");
		from("timer://test?period=50000").process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				List<Employee> employees = GeneratorEmployeeList.generateEmployeeList();
				log.info("-------------Sending--PurchaseOrderRoute-----------------");
				producerTemplate.sendBody("direct:test", employees);
			}
		});

		// two ways of marshaling data to CSV
		// 1st Step
		/*
		 * from("direct:test") //.process(new EmployeeProcessor())
		 * .marshal().bindy(BindyType.Csv, Employee.class)
		 * .to("file:data/out?fileName=MyFile.csv&delete=true&charset=utf-8");
		 */

		// 2nd Step
		BindyCsvDataFormat bindy = new BindyCsvDataFormat(Employee.class);
		bindy.setLocale("default");
		from("direct:test").marshal(bindy).to("file:data/out?fileName=EmployeeDetails.csv&delete=true&charset=utf-8");
	}

}
