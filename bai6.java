package chapter2;

import java.util.Scanner;

public class bai6 {
	//fields
	private String name ;
	private String address;
	private double cost;
	private double income ;
	private double benefit;
	//get,set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getBenefit() {
		return benefit;
	}
	public void setBenefit(double benefit) {
		this.benefit = benefit;
	}
	//contructor
	public bai6() {
		this.Input();
		this.Output();
	}
	public bai6(String name , String address , double cost , double income , double benefit ) {
		this.name=name;
		this.address=address;
	}
	public bai6(bai6 b) {
		this.name=b.name;
		this.address=b.address;
	}
	//calculate benefic
	public double calBenefit() {
		return (this.benefit=this.income - this.cost);
	}
	//input
	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input name : ");
		this.name=sc.nextLine();
		System.out.println("Input address : ");
		this.address=sc.nextLine();
		System.out.println("Input cost : ");
		this.cost=Double.parseDouble(sc.nextLine());
		System.out.println("Input income :");
		this.income=Double.parseDouble(sc.nextLine());
		
	}
	//output
	public void Output() {
		System.out.println(this.name+" at "+this.address+" has "+this.cost+" "+this.income+" "+calBenefit());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bai6 b = new bai6();
	}

}
