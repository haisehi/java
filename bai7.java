package chapter2;

import java.util.Scanner;

class person {
	protected String name ;
	protected int age ;
	protected String adderss;
	//get,set
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
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	//contructor
	public person() {
		this.Input();
		this.Output();
	}
	public person(String name , int age , String address ) {
		this.name=name;
		this.age=age;
		this.adderss=address;
	}
	public person(person p) {
		this.name=p.name;
		this.age=p.age;
		this.adderss=p.adderss;
	}
	//Input
	public void Input() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Input name : ");
		this.name=sc.nextLine();
		System.out.println("Input age : ");
		this.age=Integer.parseInt(sc.nextLine());
		System.out.println("Input address : ");
		this.adderss=sc.nextLine();
	}
	public void Output() {
		System.out.println(this.name+" is "+this.age+" at "+this.adderss);
	}
}


class Teacher extends person {
	private String institution_name;
	private String courses;
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	//contructor
	public Teacher() {
		this.Input();
		this.Output();
	}
	public  Teacher(String name , int age , String address , String institution_name , String courses ) {
		super(name , age , address);
		this.institution_name=institution_name;
		this.courses=courses;
	}
	public void Input() {
		super.Input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input institution name : ");
		this.institution_name=sc.nextLine();
		System.out.println("Input courses : ");
		this.courses=sc.nextLine();
	}
	public void Output() {
		super.Output();
		System.out.println("institution name is "+this.getInstitution_name()+" has "+this.getCourses());
	}
}


public class bai7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person p = new person();
		Teacher t = new Teacher();
	}

}
