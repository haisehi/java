package test;

import model.CounterModel;
import view.CounterView;

public class Test {
	public static void main(String[] args) {
		CounterModel ct = new CounterModel();
		ct.increment();
		ct.increment();
		ct.increment();
		System.out.println(ct.getValues());
		ct.decrement();
		ct.decrement();
		System.out.println(ct.getValues());
		
		CounterView ctv = new CounterView();
		
	}
}
