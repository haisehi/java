package Test.OOP.Inheritance;

import java.util.Scanner;

public class Employee extends Person {
	private double works ;

	public double getWorks() {
		return works;
	}

	public void setWorks(double works) {
		this.works = works;
	}
	//default contructor
	public Employee() {
		this.Input();
		this.Output();
	}
	public Employee(String name ,double rate , double works) {
		super(name , rate);
		this.works = works;
	}
	public void Input() {
		super.Input();
		Scanner key = new Scanner(System.in);
		System.out.println("works = ");
		this.works = Double.parseDouble(key.nextLine());
	}
	public double CalSalary() {
		return super.rate*1500*this.works;
	}
	public void Output() {
		super.Output();
		System.out.println(" has works ="+this.getWorks()+" has Salary="+this.CalSalary());
	}
}