import java.util.Scanner;
import java.util.Arrays;

public class Stringgg {
	public static void main(String[] args) {
//	Question 1
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập chuỗi: ");
		String inputString = input.nextLine();
		System.out.println("Chuỗi vừa nhập: " + inputString);

//	Question 2
		System.out.println("Nhập chuỗi 1: ");
		String inputString1 = input.nextLine();
		System.out.println("Nhập chuỗi 2: ");
		String inputString2 = input.nextLine();
		System.out.println("Chuỗi 1: " + inputString1);
		System.out.println("Chuỗi 2: " + inputString2);
		System.out.println("Ghép chuỗi: " + inputString1.concat(inputString2));

//	Question 3
		System.out.println("Nhập tên:");
		String hoTen = input.next();
		System.out.println("Tên sau khi nhập: " + hoTen);
		String firstChar = hoTen.substring(0, 1);
		firstChar = firstChar.toUpperCase();
		String remainmingString = hoTen.substring(1, hoTen.length());
		hoTen = firstChar + remainmingString;
		System.out.println("Ten sau khi kiểm tra: " + hoTen);

//	Question 4
		System.out.println("Nhập tên: ");
		String ten = input.next();
		for (int i = 0; i < ten.length(); i++) {
			System.out.printf("Ký tự thứ %d là: %c \n", i + 1, ten.charAt(i));
		}

//	Question 5
		System.out.println("Nhập họ: ");
		String ho = input.next();
		System.out.println("Nhập tên: ");
		String ten1 = input.next();
		System.out.println("Họ tên:  " + ho + " " + ten1);

//	Question 6
		System.out.println("Nhập họ tên đầy đủ: ");
		String hoVaTen = input.nextLine();
		String tachHo = hoVaTen.split(" ")[0]; // split("abc") => abc là đánh dấu nơi tách, [0] lần xuất hiện???????
		String tenDem = hoVaTen.split(" ")[1];
		String tachTen = hoVaTen.split(" ")[3];
		System.out.println("Họ: " + tachHo);
		System.out.println("Tên đệm: " + tenDem);
		System.out.println("Tên: " + tachTen);

//	Question 7
		System.out.println("Nhập họ và tên: ");
		String hoVaTen1 = input.nextLine();
		System.out.println("Họ và tên vừa nhập: " + hoVaTen1);
		// chuẩn hóa họ và tên

		hoVaTen1 = hoVaTen1.trim();
		hoVaTen1 = hoVaTen1.replaceAll("\\s+", " ");
		System.out.println("Họ và tên mới: " + hoVaTen1);
	}

}
