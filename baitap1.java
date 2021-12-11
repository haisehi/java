package basic;

import java.util.Scanner;

public class baitap1 {
	private int id;
	private double balance;
	// get , set
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id ;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance ;
	}
	
	public double Deposit(double deposit) {		
		this.balance = this.getBalance() + deposit;
		return this.balance;
	}
	
	public double Withdraw(double withdraw) {
		this.balance = this.getBalance() - withdraw;
		return this.balance;
	}
	
	//input id , balance
	public void InputAccount() {
		Scanner k = new Scanner(System.in);
		System.out.println("nhap id");
		this.id = k.nextInt();
		System.out.println("nhap balance");
		this.balance = k.nextDouble();

	}
	
	//output id , balance
	public void OutputAccount(){
		System.out.println("Id "+this.getId() +"has balance = "+ this.getBalance());
		System.out.println("Deposit = "+  Deposit(balance));
		System.out.println("Withdraw = "+ Withdraw(balance));
	}
		
}
