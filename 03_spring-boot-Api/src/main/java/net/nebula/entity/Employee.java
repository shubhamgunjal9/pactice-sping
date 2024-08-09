package net.nebula.entity;



public class Employee {
	
	private int id;
	private String name;
	private String pass;
	private String contact;
	private String address;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id = "+id+",name=" + name + ", pass=" + pass + ", contact=" + contact + ", address=" + address + "]";
	}
	public Employee(int id,String name, String pass, String contact, String address) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.contact = contact;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
