package chapter2;

import java.util.Scanner;

public class bai5 {
	//field hs
	private String name;
	private int age;
	private String address;
	private double mark1;
	private double mark2;
	private double mark3;
	//get(),set()
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getMark1() {
		return mark1;
	}
	public void setMark1(double mark1) {
		this.mark1 = mark1;
	}
	public double getMark2() {
		return mark2;
	}
	public void setMark2(double mark2) {
		this.mark2 = mark2;
	}
	public double getMark3() {
		return mark3;
	}
	public void setMark3(double mark3) {
		this.mark3 = mark3;
	}
	//contructor
	public bai5() {
		this.Input();
		this.Output();
	}
	//creating a parameterized constructor  
	public bai5(String name , int age , String address ) {
		this.name=name;
		this.age=age;
		this.address=address;
	}
	public bai5(bai5 f) {
		this.name=f.name;
		this.age=f.age;
		this.address=f.address;
	}
	//average mark
	public double AvgMarks() {
		return (this.mark1 + this.mark2 + this.mark3);
	}
	//Input
	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input name : ");
		this.name = sc.nextLine();
		System.out.println("Input age : ");
		this.age= Integer.parseInt(sc.nextLine());
		System.out.println("Input address :");
		this.address=sc.nextLine();
		System.out.println("Input points test of mark1 , mark2 , mark3 :");
		this.mark1=Double.parseDouble(sc.nextLine());
		this.mark2=Double.parseDouble(sc.nextLine());
		this.mark3=Double.parseDouble(sc.nextLine());		
	}
	//Output
	public void Output() {
		System.out.println(this.getName()+" is "+this.getAge()+" at "+this.getAddress()+" has "+this.AvgMarks());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bai5 f = new bai5();
	}


}
