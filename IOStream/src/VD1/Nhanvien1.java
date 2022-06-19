package VD1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
//ObjectOutputStream và ObjectInputStream
public class Nhanvien1 implements Serializable {
	public String name;
	public int age;
	public double money;
	
	public Nhanvien1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nhanvien1(String name, int age, double money) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
	}

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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Nhanvien1 [name=" + name + ", age=" + age + ", money=" + money + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int n;
		String name;
		int age;
		double money;
		File file = new File("Hello/nhanvien1.bin");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so nhan vien");
		n = sc.nextInt();
		name = sc.nextLine();
		Nhanvien1 [] nv1 = new Nhanvien1[n];
		for(int i=0; i<n;i++) {
			nv1[i] = new Nhanvien1();
			nv1[i].setName(sc.nextLine());
			nv1[i].setAge(sc.nextInt());
			name = sc.nextLine();
			nv1[i].setMoney(sc.nextDouble());
			name = sc.nextLine();
			objectOutputStream.writeObject(nv1[i]);
		}
		objectOutputStream.close();		
		fileOutputStream.close();
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			for (int i = 0; i < n; i++) {
				nv1[i]=(Nhanvien1)objectInputStream.readObject();
				System.out.println(nv1[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}	
	
	
}
