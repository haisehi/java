package Test.OOP.Inheritance;

import java.util.Scanner;

public class Person {
	//field
	protected String name;
	protected double rate ;
	//get() , set ()
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	//default contructor
	public Person() {
		this.Input();
		this.Output();
	}
	public Person (String name ,double rate ) { // person co hai tham so name va rate
		this.name=name;
		this.rate=rate;
	}
	public Person(Person p) { // p la doi tuong cua class
		this.name=p.name;
		this.rate=p.rate;
	}
	// Input() , CalSalary() , Output()
	public void Input() { // method
		double a ;
		Scanner key = new Scanner(System.in);
		System.out.println("name = ");
		this.name = key.nextLine();
		System.out.println("rate = ");
		this.rate = Double.parseDouble(key.nextLine());
		
	}
	public void calSalary() { //method
		this.Input();
		this.name ="abc";
	}
	public void Output() {
		System.out.println("Name ="+this.getName()+" has rate = "+this.getRate());
	}
}
