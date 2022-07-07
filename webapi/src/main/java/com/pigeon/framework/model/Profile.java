package com.pigeon.framework.model;

import java.util.Objects;

public class Profile {
	public Profile(String name, String email, String dob, String address, String city, String country, String pin) {
		this.name=name;
		this.email=email;
		this.dob=dob;
		this.address=address;
		this.city=city;
		this.country=country;
		this.pin=pin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Profile [name=" + name + ", email=" + email + ", dob=" + dob + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", pin=" + pin + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, city, country, dob, email, name, pin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(pin, other.pin);
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String name;
	public String email;
	public String dob;
	public String address;
	public String city;
	public String country;
	public String pin;
}
