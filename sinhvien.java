package Test.OOP.Chapter3And4;

import java.util.Scanner;

public class sinhvien implements Comparable<sinhvien> {
	private String name;
	private double avg ;
	//get , set
	//id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name ;
	}
	//avg
	public double getAvg() {
		return avg ;
	}
	public void setAvg(double avg) {
		this.avg = avg ;
	}
	//default contructor
	public sinhvien () {
		this.name ="";
		this.avg = 0.0 ;
	}
//	parameterized contructor
	public sinhvien(String name , double avg) {
		this.name = name;
		this.avg = avg;
	}
	public sinhvien(sinhvien s) {
		this.name = s.name;
		this.avg = s.avg ;
	}
	//Input
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name");
		this.name = sc.next();
		System.out.println("Enter average");
		this.avg=sc.nextDouble();
	}
	//output
	public void Output() {
		System.out.println("studen has "+this.getName()+" and average = "+this.getAvg());
	}
	
	@Override
	public int compareTo(sinhvien other) {
		// TODO Auto-generated method stub
		sinhvien sinhvien = other;
		return (int)(this.avg - other.avg);
	}

}
