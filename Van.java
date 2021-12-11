package deThiGiuaKy;

import java.util.Scanner;

public class Van {
	private int id ;
	private String name ;
	private double price ;
	private double extraOut ;
	private int quantity ;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getExtraOut() {
		return extraOut;
	}
	public void setExtraOut(double extraOut) {
		this.extraOut = extraOut;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public  Van() {
		
	}
	public Van(int id, String name, double price, double extraOut, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.extraOut = extraOut;
		this.quantity = quantity;
	}
	
	public double priceForSale() {
		double priceForSale ;
		if (quantity >= 50 ) {
			priceForSale = this.price + this.extraOut + (this.extraOut*(10/100));
		} else {
			priceForSale = this.price + this.extraOut ;
		}
		return priceForSale ;
	}
	@Override
	public String toString() {
		return "Van [id=" + id + ", name=" + name + ", price=" + price + ", extraOut=" + extraOut + ", quantity="
				+ quantity + "]" + priceForSale();
	}
	


}
