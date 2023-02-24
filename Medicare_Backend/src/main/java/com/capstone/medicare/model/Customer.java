package com.capstone.medicare.model;

import javax.persistence.*;

@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custId")
	private long id;
	@Column(name="custName")
	private String name;
	@Column(name="custmail",unique=true)
	private String mail;
	@Column(name="custAddr")
	private String address;
	
	@Column(name="custPhNo")
	private int phNo;
	@Column(name="custPwd")
	private String password;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhNo() {
		return phNo;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mail=" + mail + ", address=" + address + ", phNo=" + phNo
				+ ", password=" + password + "]";
	}
	
}
	
	