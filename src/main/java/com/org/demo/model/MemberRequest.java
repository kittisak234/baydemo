package com.org.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberRequest {
	
	@JsonProperty("user_name")
	@NotBlank(message = "User Name cannot be Blank")
	@Size(max = 10, message = "User Name should not be greater than 10")
	private String userName;
	
	@JsonProperty("password")
	@NotBlank(message = "Password cannot be Blank")
	@Size(max = 10, message = "Password should not be greater than 10")
	private String password;
	
	@JsonProperty("first_name")
	@NotBlank(message = "Firdt Name cannot be Blank")
	@Size(max = 30, message = "Full Name should not be greater than 30")
	private String firstName;
	
	@JsonProperty("last_name")
	@NotBlank(message = "Last Name cannot be Blank")
	@Size(max = 30, message = "Last Name should not be greater than 30")
	private String lastName;

	@JsonProperty("age")
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;
	
	@JsonProperty("phone")
	@NotBlank(message = "Phone cannot be Blank")
	@Size(max = 10, message = "Phone should not be greater than 10")
	private String phone;
	
	@JsonProperty("email")
	@NotBlank(message = "Email cannot be Blank")
	@Email(message = "Email should be valid")
	private String email;
	
	@JsonProperty("salary")
	@NotBlank(message = "Salary cannot be Blank")
	private String salary;
	
	
	@JsonProperty("address")
	@NotBlank(message = "Address cannot be Blank")
	private String address;
	
	
	@JsonIgnore
	private String memberType;

	@JsonIgnore
	private String referenceCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
}
