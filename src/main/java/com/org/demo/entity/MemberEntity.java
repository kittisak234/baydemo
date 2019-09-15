package com.org.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "MEMBER")
public class MemberEntity {
		
	@Id
	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private Long id;
	
	@Column(name = "Reference_Code", length = 12, nullable = false)
	private String referenceCode;
	
	@Column(name = "User_Name", length = 10, nullable = false)
	private String userName;

	@Column(name = "Password", length = 10, nullable = false)
	private String password;

	@Column(name = "First_Name", length = 30, nullable = false)
	private String firstName;

	@Column(name = "Last_Name", length = 30, nullable = false)
	private String lastName;

	@Column(name = "Age", length = 3, nullable = false)
	private Long age;

	@Column(name = "Phone", length = 10, nullable = false)
	private String phone;

	@Column(name = "Email", length = 50, nullable = false)
	private String email;

	@Column(name = "Salary", length = 10, nullable = false)
	private String salary;

	@Column(name = "Address", length = 200, nullable = false)
	private String address;


	@Column(name = "Member_Type", length = 10, nullable = false)
	private String memberType;

	@Column(name = "Create_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "Update_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public Long getId() {
		return id;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
