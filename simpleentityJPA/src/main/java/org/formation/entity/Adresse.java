package org.formation.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String street;
	private String city;
	private Long zipcode;
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getZipcode() {
		return zipcode;
	}
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Adresse [street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	
	
}
