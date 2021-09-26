package Assignment_2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class System_Out_Printf {
	public static void main(String[] args) {
//	Bảng Department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Maketing";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "IT";

		Department department4 = new Department();
		department4.departmentId = 4;
		department4.departmentName = "Manager";

// Bảng Position
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = PositionName.DEV;

		Position position2 = new Position();
		position2.positionId = 2;
		position2.positionName = PositionName.PM;

		Position position3 = new Position();
		position3.positionId = 3;
		position3.positionName = PositionName.SCRUM_MASTER;

		Position position4 = new Position();
		position4.positionId = 4;
		position4.positionName = PositionName.TEST;

		// Bảng Account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "Account1@gmail.com";
		account1.userName = "a.nguyenvan";
		account1.fullName = "Nguyễn Văn An";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDate.of(1995, 9, 18);

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "account2@gmail.com";
		account2.userName = "binh.nguyenvan";
		account2.fullName = "Nguyễn Văn Bình";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = LocalDate.of(1996, 8, 12);

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "account3@gmail.com";
		account3.userName = "thu.tranthi";
		account3.fullName = "Trần Thị Thu";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = LocalDate.of(1995, 11, 21);

		Account account4 = new Account();
		account4.accountId = 1;
		account4.email = "account4@gmail.com";
		account4.userName = "vinh.nguduy";
		account4.fullName = "Ngũ Duy Vinh";
		account4.department = department4;
		account4.position = position4;
		account4.createDate = LocalDate.of(2002, 1, 18);

		Account account5 = new Account();
		account5.accountId = 5;
		account5.email = "account5@gmail.com";
		account5.userName = "thanh.nguyenchi";
		account5.fullName = "Nguyễn Chí Thành";
		account5.department = department1;
		account5.position = position1;
		account5.createDate = LocalDate.of(1998, 1, 1);

		Account account6 = new Account();
		account6.accountId = 6;
		account6.email = "account6@gmail.com";
		account6.userName = "lam.chuhong";
		account6.fullName = "Chu Hồng Lâm";
		account6.department = department2;
		account6.position = position2;
		account6.createDate = LocalDate.of(1997, 10, 30);

		// Bảng Group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "ManchesTer United";
		group1.creator = account4;
		group1.createDate = LocalDate.of(2020, 8, 12);

		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "ManchesTer City";
		group2.creator = account2;
		group2.createDate = LocalDate.of(2020, 1, 2);

		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "Liverpool";
		group3.creator = account3;
		group3.createDate = LocalDate.of(2020, 5, 20);

		Group group4 = new Group();
		group4.groupId = 4;
		group4.groupName = "Leed United";
		group4.creator = account4;
		group4.createDate = LocalDate.of(2020, 12, 15);

		Group group5 = new Group();
		group5.groupId = 5;
		group5.groupName = "Arsenal";
		group5.creator = account5;
		group5.createDate = LocalDate.of(2020, 11, 4);

		Group[] groupOfAccount1 = { group1, group3, group4, group5 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group1, group2, group5 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group1, group2, group3 };
		account3.groups = groupOfAccount3;

		Group[] groupOfAccount4 = { group1, group2, group3, group5 };
		account4.groups = groupOfAccount4;

		Group[] groupOfAccount5 = { group3, group4, group5 };
		account5.groups = groupOfAccount5;

		Group[] groupOfAccount6 = { group4, group5 };
		account6.groups = groupOfAccount6;

		Account[] accountOfGroup1 = { account1, account2, account3, account4 };
		group1.accounts = accountOfGroup1;

		Account[] accountOfGroup2 = { account2, account3, account4 };
		group2.accounts = accountOfGroup2;

		Account[] accountOfGroup3 = { account1, account5, account3, account4 };
		group3.accounts = accountOfGroup3;

		Account[] accountOfGroup4 = { account1, account6, account5, account4 };
		group4.accounts = accountOfGroup4;

		Account[] accountOfGroup5 = { account1, account2, account5, account6 };
		group5.accounts = accountOfGroup5;

		Account danhSachAccount[] = { account1, account2, account3, account4, account5, account6 };
		Group danhSachGroup[] = { group1, group2, group3, group4, group5 };

//	Question 1:
//		Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
//		nguyên đó
		int n = 5;
		System.out.println("Số nguyên i = " + n);

//	Question 2:
//		Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//		ra số nguyên đó thành định dạng như sau: 100,000,000
		int b = 100000000;
		System.out.printf("Số nguyên b = %,d", b);
		System.out.println("\n");

//	Question 3:
//		Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//		thực đó chỉ bao gồm 4 số đằng sau
		float c = 5.567098f;
		System.out.printf("Số thực c = %5.4f", c);
		System.out.println("\n");
//	Question 4:
//		Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//		dạng như sau:
//		Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//		Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		String hoVaTen = "Nguyễn Văn A";
		System.out.println("Tôi tên là: " + hoVaTen + " và tôi đang độc thân.");
//	Question 5:
//		Lấy thời gian bây giờ và in ra theo định dạng sau:
//		24/04/2020 11h:16p:20s
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
//	Question 6:
//		In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//		table (giống trong Database)
		System.out.printf("%-20s \t %-20s \t %-10s \n","Email","FullName","Tên phòng ban");
		for(int i=0;i<danhSachAccount.length;i++) {
			System.out.printf("%-20s \t %-20s \t %-10s \n",danhSachAccount[i].email, danhSachAccount[i].fullName, danhSachAccount[i].department.departmentName);
		}
	}
}
