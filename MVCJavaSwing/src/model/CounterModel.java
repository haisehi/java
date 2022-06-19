package model;

public class CounterModel {
	private int values;
	//constructor
	public CounterModel(){
		this.values =0;	
	}
	//get,set
	public int getValues() {
		return values;
	}
	public void setValues(int values) {
		this.values = values;
	}
	//ham tang 
	public void increment() {
		this.values++;
	}
	//ham giam
	public void decrement() {
		this.values--;
	}
	//ham reset
	public void reset() {
		this.values=0;
	}
	
}
