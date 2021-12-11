package chapter2;
import java.lang.StringBuffer;
public class bai2 {
	public static void append(String a) {
		// create a StringBuilder object
        // using StringBuilder() constructor
        StringBuilder str = new StringBuilder();            
        str.append("GFG"); //được sử dụng để nối biểu diễn chuỗi của một số đối số vào chuỗi
        // print string
        System.out.println("String = " + str.toString()); 
	}
	public static void capacity(String a) {
        // create a StringBuilder object
        // using StringBuilder(capacity) constructor
        StringBuilder str1  = new StringBuilder(10); 
        // print string
        System.out.println("String1 capacity = " + str1.capacity()); //Trả về dung lượng hiện tại.
	}
	
	public static void main(String[] args) {
		String a = null;
		// TODO Auto-generated method stub                                            
		append(a);
		capacity(a);
	}
}
