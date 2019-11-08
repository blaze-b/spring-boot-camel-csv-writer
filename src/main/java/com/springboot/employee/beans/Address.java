package com.springboot.employee.beans;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "," ,skipFirstLine = true, generateHeaderColumns = true)
public class Address {
	
	@DataField(columnName = "Address_Name",pos = 6, required = true, trim = true)
	private String addressName;

	@DataField(columnName = "Location", pos = 7, required = true, trim = true)
	private String location;

	@DataField(columnName = "City", pos = 8, required = true, trim = true)
	private String city;

	public String getAddressName() {
		return addressName;
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressName=" + addressName + ", location=" + location + ", city=" + city + "]";
	}

}
