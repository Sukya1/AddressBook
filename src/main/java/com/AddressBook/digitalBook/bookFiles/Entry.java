package com.AddressBook.digitalBook.bookFiles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Entry {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	private String firstName;
	private String lastName;
	private String phoneNumber; 
	private String emailAddress; 
	private String homeAddress; 
	
	public Entry() {
		
	}

	public Entry(String firstName, String lastName, String phoneNumber, String emailAddress, String homeAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.homeAddress = homeAddress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return "Entry [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", homeAddress=" + homeAddress + "]";
	}		
}
