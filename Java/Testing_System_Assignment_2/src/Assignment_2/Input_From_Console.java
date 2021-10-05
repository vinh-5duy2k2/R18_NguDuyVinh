package Assignment_2;

import java.util.Random;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input_From_Console {
	public static void main(String[] args) {
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

//	Bảng Position
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

//	Bảng Account
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

//	Bảng Group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "ManchesTerUnited";
		group1.creator = account4;
		group1.createDate = LocalDate.of(2020, 8, 12);
		group1.accounts = new ArrayList<Account>();

		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "ManchesTerCity";
		group2.creator = account2;
		group2.createDate = LocalDate.of(2020, 1, 2);
		group2.accounts = new ArrayList<Account>();

		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "Liverpool";
		group3.creator = account3;
		group3.createDate = LocalDate.of(2020, 5, 20);
		group3.accounts = new ArrayList<Account>();

		Group group4 = new Group();
		group4.groupId = 4;
		group4.groupName = "LeedUnited";
		group4.creator = account4;
		group4.createDate = LocalDate.of(2020, 12, 15);
		group4.accounts = new ArrayList<Account>();

		Group group5 = new Group();
		group5.groupId = 5;
		group5.groupName = "Arsenal";
		group5.creator = account5;
		group5.createDate = LocalDate.of(2020, 11, 4);
		group5.accounts = new ArrayList<Account>();
//		Danh sách các group trong mỗi Account
		account1.groups = new ArrayList<Group>();
		account1.groups.add(group1);
		account1.groups.add(group3);
		account1.groups.add(group4);
		account1.groups.add(group5);

		account2.groups = new ArrayList<Group>();
		account1.groups.add(group1);
		account1.groups.add(group2);
		account1.groups.add(group5);

		account3.groups = new ArrayList<Group>();
		account1.groups.add(group1);
		account1.groups.add(group2);
		account1.groups.add(group3);

		account4.groups = new ArrayList<Group>();
		account1.groups.add(group1);
		account1.groups.add(group2);
		account1.groups.add(group3);
		account1.groups.add(group5);

		account5.groups = new ArrayList<Group>();
		account1.groups.add(group3);
		account1.groups.add(group4);
		account1.groups.add(group5);

		account6.groups = new ArrayList<Group>();
		account1.groups.add(group4);
		account1.groups.add(group5);
		List<Account> listAcc = new ArrayList<Account>();
		listAcc.add(account6);
		listAcc.add(account5);
		listAcc.add(account4);
		listAcc.add(account3);
		listAcc.add(account2);
		listAcc.add(account1);

		List<Group> listGroup = new ArrayList<Group>();
		listGroup.add(group5);
		listGroup.add(group4);
		listGroup.add(group3);
		listGroup.add(group2);
		listGroup.add(group1);
//
////		Question1:
//
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Nhập số nguyên thứ nhất: ");
//		int x = sc.nextInt();
//		System.out.println("Nhập số nguyên thứ hai: ");
//		int y = sc.nextInt();
//		System.out.println("Nhập số nguyên thứ ba: ");
//		int z = sc.nextInt();
//		System.out.println("Số nguyên thứ 1: " + x);
//		System.out.println("Số nguyên thứ 2: " + y);
//		System.out.println("Số nguyên thứ 3: " + z);
////	Question2:
//
//		System.out.println("Nhập số thực thứ nhất: ");
//		float a = sc.nextFloat();
//		float b = sc.nextFloat();
//		System.out.println("Số thực thứ 1: " + a);
//		System.out.println("Số thực thứ 2: " + b);
//
//////		Question3:
//		System.out.println("Nhập họ : ");
//		String ho = sc.next();
//		System.out.println("Nhập tên: ");
//		String ten = sc.next();
//		System.out.println("Họ và tên của bạn: " + ho + " " + ten);
//////		Question7:
//		System.out.println("Nhập số chẵn: ");
//		int soChan = sc.nextInt();
//		if (soChan % 2 == 0) {
//			System.out.println("Số bạn nhập là số chẵn.");
//		} else {
//			System.out.println("Số bạn nhập không là số chẵn.");
//		}

//		Question 8 + Question 10:
		createAccount1(listAcc, listGroup); // Chưa có Random

////		Question 9: 
//		addGroupToAccount(listAcc, listGroup);

//		Question 11:
		createAccount2(listAcc, listGroup); // Có Random
	}

//		Question 8:
//		tạo account mới
	public static void newAccount(List<Account> listAccount) {
		Account newAcc = new Account();
		listAccount.add(newAcc);
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		newAcc.accountId = sc.nextInt();
		System.out.println("Nhập userName:");
		newAcc.userName = sc.next();
		System.out.println("Nhập Email:");
		newAcc.email = sc.next();
	}

//		Tạo department mới
	public static void newDepartment() {
		Department newDept = new Department();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập DepartmentID: ");
		newDept.departmentId = sc.nextByte();
		System.out.println("Nhập DepartmentName: ");
		newDept.departmentName = sc.next();
	}

	public static void createAccount1(List<Account> listAccount, List<Group> listGroup) {
		Scanner sc = new Scanner(System.in);
		int i;
		do {
			System.out.println("Chương trình:");
			System.out.println("1. Tạo account mới");
			System.out.println("2. Tạo department mới");
			System.out.println("3. Thêm account vào Group");
			System.out.println("0. Thoát chương trình");
			System.out.println("Chọn chức năng: ");
			i = sc.nextInt();
			if (i == 1) {
				newAccount(listAccount);
			} else if (i == 2) {
				newDepartment();
			} else if (i == 3) {
				addGroupToAccount(listAccount, listGroup);
			} 
		} while (i!= 0);
	}
//		Question9:

	public static void addGroupToAccount(List<Account> listAccount, List<Group> listGroup) {
//			in ra danh sách các usernames;
		System.out.println("Danh sách account hiện có: ");
		for (int i = 0; i < listAccount.size(); i++) {
			System.out.printf("Username người thứ %d: %s \n", i + 1, listAccount.get(i).userName);
		}
//			nhập tên username của account => lấy ra account có chứa tên vừa nhập 
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập userName Account cần thêm: ");
		String inputName = input.next();
		int indexUser = -1;
		for (int i = 0; i < listAccount.size(); i++) {
			if (inputName.equals(listAccount.get(i).userName)) {
				indexUser = i;
			}
		}

//		Danh sách các group
		System.out.println("\n");
		System.out.println("Danh sách các group:");
		for (int i = 0; i < listGroup.size(); i++) {
			System.out.println("GroupName: " + listGroup.get(i).groupName);
		}

//		Nhập tên group => lấy ra group chứa tên group vừa nhập để thêm account
		System.out.print("Nhập GroupName để thêm account: ");
		String inputGroupName = input.next();

		int indexGroup = -1;
		for (int i = 0; i < listGroup.size(); i++) {
			if (inputGroupName.equals(listGroup.get(i).groupName)) {
				indexGroup = i;
			}
		}

//		Thêm account vào group
		if (indexUser != -1 && indexGroup != -1) {
			listGroup.get(indexGroup).accounts.add(listAccount.get(indexUser));
			System.out.printf("Danh sách account trong group %s sau khi thêm: ", listGroup.get(indexGroup).groupName);
			for (Account acc : listGroup.get(indexGroup).accounts) {
				System.out.println(acc.userName);
			}
		} else {
			System.out.println("Nhập sai");
		}
	}
//		Quesion 11: 

	public static void createAccount2(List<Account> listAccount, List<Group> listGroup) {
		Scanner sc = new Scanner(System.in);
		int i;
		do {
			System.out.println("Chương trình:");
			System.out.println("1. Tạo account mới");
			System.out.println("2. Tạo department mới");
			System.out.println("3. Thêm account vào Group");
			System.out.println("4. Thêm account vào Group Random");
			System.out.println("0. Thoát chương trình");
			System.out.println("Chọn chức năng: ");
			i = sc.nextInt();
			if (i == 1) {
				newAccount(listAccount);
			} else if (i == 2) {
				newDepartment();
			} else if (i == 3) {
				addGroupToAccount(listAccount, listGroup);
			} else if (i == 4) {
				addGroupToAccountRandom(listAccount, listGroup);
			} 
		} while (i != 0);

	}

	public static void addGroupToAccountRandom(List<Account> listAccount, List<Group> listGroup) {
//		in ra danh sách các usernames;
		System.out.println("Danh sách account hiện có: ");
		for (int i = 0; i < listAccount.size(); i++) {
			System.out.printf("Username người thứ %d: %s \n", i + 1, listAccount.get(i).userName);
		}
//		nhập tên username của account => lấy ra account có chứa tên vừa nhập 
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập userName Account cần thêm: ");
		String inputName = input.next();
		int indexUser = -1;
		for (int i = 0; i < listAccount.size(); i++) {
			if (inputName.equals(listAccount.get(i).userName)) {
				indexUser = i;
			}
		}

//	Danh sách các group
		System.out.println("\n");
		System.out.println("Danh sách các group:");
		for (int i = 0; i < listGroup.size(); i++) {
			System.out.println("GroupName: " + listGroup.get(i).groupName);
		}

//	Nhập tên group => lấy ra group chứa tên group vừa nhập để thêm account
		System.out.println("Random GroupName để thêm account: ");
		Random rand = new Random();
		int randomGroupID = rand.nextInt(6);

//	int indexGroup = -1;
//	for (int i = 0; i < listGroup.size(); i++) {
//		if (inputGroupName.equals(listGroup.get(i).groupName)) {
//			indexGroup = i;
//		}
//	}

//	Thêm account vào group
		if (indexUser != -1) {
			listGroup.get(randomGroupID).accounts.add(listAccount.get(indexUser));
			System.out.printf("Danh sách account trong group %s sau khi thêm\n: ",
					listGroup.get(randomGroupID).groupName);
			for (Account acc : listGroup.get(randomGroupID).accounts) {
				System.out.println(acc.userName);
			}
		} else {
			System.out.println("Nhập sai");
		}
	}

}
