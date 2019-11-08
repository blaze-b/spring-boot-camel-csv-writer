package com.springboot.order;

import java.math.BigDecimal;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class PurchaseOrderRoute extends RouteBuilder {

	@Autowired
	private ProducerTemplate producerTemplate;
	 
	//private String sftpDelimiter = "\t";

	// Otherwise single quotes will be doubled.
	@Override
	public void configure() throws Exception {

		//final DataFormat bindy = new BindyCsvDataFormat(PurchaseOrder.class);

		System.out.println("Entering----PurchaseOrderComponent");
		from("timer://test?period=50000").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				// extract the name parameter from the Camel message which we want to use
				// when invoking the bean
				System.out.println("**********Entering***PurchaseOrderRoute*********************");
				PurchaseOrder order = new PurchaseOrder();
				order.setAmount(3);
				order.setName("AKC4433");
				order.setPrice(new BigDecimal(157.79));
				// HashMap<String, PurchaseOrder> map = new HashMap<String, PurchaseOrder>();
				// map.put("AKC4433", order);
				// exchange.getOut().setBody(map);
				log.info("-------------Sending--PurchaseOrderRoute-----------------");
				producerTemplate.sendBody("direct:test", order);
				;
			}
		});

		from("direct:test").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				log.info("-------------Receiving--PurchaseOrderRoute-----------------");
				PurchaseOrder order = exchange.getIn().getBody(PurchaseOrder.class);
				System.out.println(order);
				System.out.println(order.getName());
				System.out.println(order.getAmount());
				System.out.println(order.getPrice());
			}
		}).marshal().bindy(BindyType.Csv, com.springboot.order.PurchaseOrder.class)
				.to("file:data/out?fileName=MyFile.csv&charset=utf-8");

	}

}
