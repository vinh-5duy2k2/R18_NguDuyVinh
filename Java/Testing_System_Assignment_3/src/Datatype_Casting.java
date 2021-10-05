import java.util.Random;
import java.util.Scanner;
public class Datatype_Casting {
//	Hàm random 
	public static int usingRandomClass() {
		Random rand = new Random();
		int ranNum = rand.nextInt(99999) + 1;
		return ranNum;
	}
// Hàm nhập 2 số nguyên rồi lấy thương
	public static int insertValues(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số a:");
		int a = sc.nextInt();
		System.out.println("Nhập số b:");
		int b = sc.nextInt();
		System.out.println("Số a: " +a);
		System.out.println("Số b: " +b);
		return a/b;
	}
	public static void main(String[] args) {

//		Question1: 
		float luong1 = 5240.5f;
		float luong2 = 10970.055f;
		int lamTronLuong1 = (int) luong1;
		int lamTronLuong2 = (int) luong2;
		System.out.println("Giá trị lương 1 ban đầu: " + luong1);
		System.out.println("Giá trị lương 2 ban đầu: " + luong2);
		System.out.println("Giá trị lương 1 lúc sau: " + lamTronLuong1);
		System.out.println("Giá trị lương 2 lúc sau: " + lamTronLuong2);
	

//		Question2:
		int i = usingRandomClass();
		System.out.printf("Random number is %05d %n", i);
//		Question3:
		System.out.println("2 số cuối: " +i%100);
//		Question4:
		System.out.println("Thương của a/b : " + insertValues());
		
	}

}
