package com.pigeon.framework.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Length;

public class Profile {
	public String name;
	@NotNull()
	@Size(min = 5, message = "Email length must by at least 5 charachers...")
	public String email;
	public Date dob;
	public String address;
	public String city;
	public String country;
	//@Length(min = 6, max = 6, message = "Pin code should be 6 digit...")
	public int pin;
	
	public Profile() {
		
	}
	
	public Profile(String name, String email, Date dob, String address, String city, String country, int pin) {
		this.name=name;
		this.email=email;
		this.dob=dob;
		this.address=address;
		this.city=city;
		this.country=country;
		this.pin=pin;
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
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name) && pin == other.pin;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
