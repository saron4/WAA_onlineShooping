package com.group3.onlineShooping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String street;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String zip;

	public Address() {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Address))
			return false;
		Address address = (Address) o;
		return Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getCity(), address.getCity())
				&& Objects.equals(getState(), address.getState()) && Objects.equals(getZip(), address.getZip());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStreet(), getCity(), getState(), getZip());
	}

	@Override
	public String toString() {
		return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", state='" + state + '\''
				+ ", zip='" + zip + '\'' + '}';
	}
}
