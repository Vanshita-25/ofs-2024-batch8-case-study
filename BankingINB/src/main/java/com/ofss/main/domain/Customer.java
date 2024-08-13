package com.ofss.main.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
	@Column(name="address_1")
    private String address1;
	@Column(name="address_2")
    private String address2;
	@Column(name="address_3")
    private String address3;
	@Column(name="city")
    private String city;
	@Column(name="state")
    private String state;
	@Column(name="zip")
    private int zip;
	@Column(name="phone")
    private int phone;
	@Column(name="cell")
    private int cell;
	@Column(name="email")
    private String email;
	@Column(name="approval_status")
    private String approvalStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
    private Login login;
    
  //Constructors
    // Default constructor
    public Customer() {
       System.out.println("Default Constructor for Customer");
    }

    
    public Customer(int customerId, String firstName, String lastName, String address1, String address2,
           String address3, String city, String state, int zip, int phone, int cell, String email,
           String approvalStatus, Login login) {
       this.customerId = customerId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.address1 = address1;
       this.address2 = address2;
       this.address3 = address3;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.phone = phone;
       this.cell = cell;
       this.email = email;
       this.approvalStatus = approvalStatus;
       this.login = login;
   }

   // Parameterized constructor
    public Customer(String firstName, String lastName, String address1, String address2, String address3, String city, String state, int zip, int phone, int cell, String email, String approvalStatus, Login login) {
       this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.cell = cell;
        this.email = email;
        this.approvalStatus = approvalStatus;
        this.login = login;
        System.out.println("Overloaded constructor for Customer");
    }

    
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCell() {
		return cell;
	}
	public void setCell(int cell) {
		this.cell = cell;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", cell=" + cell + ", email=" + email
				+ ", approvalStatus=" + approvalStatus + ", login=" + login + "]";
	}


}
