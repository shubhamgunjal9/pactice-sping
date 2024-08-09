package com.project;

public class Employee {

	private int empId;
	private String empName;
	private long contact;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		System.out.println("setter injection");
		this.empId = empId;
	}
	public String getEmpName() {
		
		return empName;
	}
	public void setEmpName(String empName) {
		System.out.println("setter injection");
		this.empName = empName;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		System.out.println("setter injection");
		this.contact = contact;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, long contact) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.contact = contact;
		System.out.println("constructor injection");
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", contact=" + contact + "]";
	}
	
	
}
