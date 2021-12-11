package chapter2;
import java.lang.Character;
public class bai1 {
// test lest 5 method
//	ta su dung method
	public static void isLetter(char ch) {
		System.out.println("isLetter");
//		methor isLetter dung de kiem tra co phai ky tu nam trong khoang a-zA-Z khong
		System.out.println("A is "+Character.isLetter('A'));
		System.out.println("a is "+Character.isLetter('a'));
		System.out.println("0 is "+Character.isLetter('0'));
	}
	public static void isDight(char ch) {
//		isDigit(): Kiểm tra một ký tự có phải là một ký số hay không.
		System.out.println("isDigit");
		System.out.println("a is "+Character.isDigit('a'));
		System.out.println("1 is "+Character.isDigit('1'));
	}
	public static void isWhitespace(char ch) {
//	isWhitespace(): Trả về true nếu giá trị char trong object là whitespace
		System.out.println("isWhitespace");
		System.out.println("A is "+Character.isWhitespace('A'));
		System.out.println("' ' is "+Character.isWhitespace(' '));
	}
	public static void isUpperCase(char ch) {
//		isUpperCase(): Trả về true nếu ký tự nằm trong khoảng A-Z.
		System.out.println("isUppercase");
		System.out.println("A is "+Character.isUpperCase('A'));
		System.out.println("a is "+Character.isUpperCase('a'));
		System.out.println("65 is "+Character.isUpperCase(65));
	}
	public static void isLowerCase(char ch) {
//		isLowerCase(): Trả về true nếu ký tự nằm trong khoảng a-z.
		System.out.println("isLowerCase");
		System.out.println("A is "+Character.isLowerCase('A'));
		System.out.println("a is "+Character.isLowerCase('a'));
		System.out.println("65 is "+Character.isLowerCase(65));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character ch = new Character('a');
		isLetter(ch);
		isDight(ch);
		isWhitespace(ch);
		isUpperCase(ch);
		isLowerCase(ch);
	}

}
