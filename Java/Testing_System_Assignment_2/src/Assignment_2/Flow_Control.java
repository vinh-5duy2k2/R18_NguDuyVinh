package Assignment_2;

import java.time.LocalDate;

public class Flow_Control {
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
//		IF
//		Question 1:
		// Kiểm tra account thứ 2
		// Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
		// "Nhân viên này chưa có phòng ban"
		// Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."
		if (account2.department == null) { // => do kiểu byte k so sánh được với null
			System.out.println("Nhân viên này chưa có phòng ban!!");
		} else {
			System.out.println("Phòng ban của nhân viên này là: " + account2.department.departmentName);
			;
		}
//		Question 2:
		// Kiểm tra account thứ 2
		// Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
		// Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
		// này là Java Fresher, C# Fresher"
		// Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
		// quan trọng, tham gia nhiều group"
		// Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
		// người hóng chuyện, tham gia tất cả các group"
		int dem;
		dem = account2.groups.length;
		if (dem == 0) {
			System.out.println("Nhân viên chưa có group");
		} else if (dem >= 1 && dem <= 2) {
			System.out.println("Nhân viên thuộc group: ");
			for (int i = 0; i < account2.groups.length; i++) {
				System.out.println(account2.groups[i].groupName);
			}
		} else if (dem == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group!!");
		} else {
			System.out.println("Nhân viên này hóng chuyên, tham gia tất cả các group!!1");
		}
//		Question 3:
//			Sử dụng toán tử ternary để làm Question 1
		System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban!!"
				: "Nhân viên này có phòng ban là: " + account2.department.departmentName);
//		Question 4:
//			Sử dụng toán tử ternary để làm yêu cầu sau:
//			Kiểm tra Position của account thứ 1
//			Nếu Position = Dev thì in ra text "Đây là Developer"
//			Nếu không phải thì in ra text "Người này không phải là Developer"
		System.out.println(account1.position.positionName == PositionName.DEV ? "Đây là Developer"
				: "Người này không phải Developer");
//		SWITCH CASE
//		Question 5:
		// Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
		// Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
		// Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
		// Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
		// Còn lại in ra "Nhóm có nhiều thành viên"
		dem = group1.accounts.length;
		switch (dem) {
		case 1: {
			System.out.println("Nhóm có 1 thành viên");
			break;
		}
		case 2: {
			System.out.println("Nhóm có 2 thành viên");
			break;
		}
		case 3: {
			System.out.println("Nhóm có 3 thành viên");
			break;
		}
		default:
			System.out.println("Nhóm có nhiều thành viên");
		}
//		Question 6:
	//		Sử dụng switch case để làm lại Question 2
		dem = account2.groups.length;
		switch (dem) {
		case 0: {
			System.out.println("Nhân viên chưa có group");
			break;
		}
		case 1: {
			System.out.println("Group nhân viên là: " + account2.groups[0].groupName);
			break;
		}
		case 2: {
			System.out.println(
					"Group nhân viên là: " + account2.groups[0].groupName + "," + account2.groups[1].groupName);
			break;
		}
		case 3: {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		}
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

//			Question 7:
	//			Sử dụng switch case để làm lại Question 4
		switch (account1.position.positionName) {
		case DEV: {
			System.out.println("Đây là developer");
			break;
		}
		default:
			System.out.println("Người này không phải là developer");
		}
//		FOREACH
//		Question 8:
	//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
	//		họ
		for (Account account : danhSachAccount) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullName);
			System.out.println("Tên phòng ban: " + account.department.departmentName);
			System.out.println("\n");
		}
//		Question 9:
	//		In ra thông tin các phòng ban bao gồm: id và name
		Department danhSachDepartment[] = {department1,department2,department3,department4};
		for (Department  department : danhSachDepartment) {
			System.out.println("DepartmentID: "+department.departmentId);
			System.out.println("DepartmentName: " +department.departmentName);
			System.out.println("\n");
		}
//		FOR
//		Question 10:
	//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
	//		họ theo định dạng như sau:
	//		Thông tin account thứ 1 là:
	//		Email: NguyenVanA@gmail.com
	//		Full name: Nguyễn Văn A
	//		Phòng ban: Sale
	//		Thông tin account thứ 2 là:
	//		Email: NguyenVanB@gmail.com
	//		Full name: Nguyễn Văn B
	//		Phòng ban: Marketting
		
		for(int i=0;i<danhSachAccount.length;i++) {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
		}
		
//		Question 11:
	//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
	//		Thông tin department thứ 1 là:
	//		Id: 1
	//		Name: Sale
	//		Thông tin department thứ 2 là:
	//		Id: 2
	//		Name: Marketing
		for(int i=0;i<danhSachDepartment.length;i++) {
			System.out.println("Thông tin Department thứ: " +(i+1));
			System.out.println("DepartmentID: "+danhSachDepartment[i].departmentId);
			System.out.println("DepartmentName: " +danhSachDepartment[i].departmentName);
			System.out.println("\n");
		}
//
//		Question 12:
	//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 11
		for(int i=0;i<2;i++) {
			System.out.println("Thông tin Department thứ: " +(i+1));
			System.out.println("DepartmentID: "+danhSachDepartment[i].departmentId);
			System.out.println("DepartmentName: " +danhSachDepartment[i].departmentName);
			System.out.println("\n");
		}
//		Question 13:
	//		In ra thông tin tất cả các account ngoại trừ account thứ 2
		for(int i=0;i<danhSachAccount.length;i++) {
			if(i==1) continue;
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
		}
//		Question 14:
	//		In ra thông tin tất cả các account có id < 4
		for(int i=0;i<3;i++) {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
		}
//		Question 15:
	//		In ra các số chẵn nhỏ hơn hoặc bằng 20
		for(int i=0;i<=20;i++){
			if(i%2==0) {
				System.out.println(i);
			}
		}
//		WHILE
//		Question 16:
	//		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
	//		lệnh break, continue
//			while : question 10
		int i=0;
		while(i<danhSachAccount.length) {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
			i++;
		}
//			while : question 11
		i=0;
		while(i<danhSachDepartment.length) {
			System.out.println("Thông tin Department thứ: " +(i+1));
			System.out.println("DepartmentID: "+danhSachDepartment[i].departmentId);
			System.out.println("DepartmentName: " +danhSachDepartment[i].departmentName);
			System.out.println("\n");
			i++;
		}
//		while : question 12
		i=0;
		while(i<2) {
			System.out.println("Thông tin Department thứ: " +(i+1));
			System.out.println("DepartmentID: "+danhSachDepartment[i].departmentId);
			System.out.println("DepartmentName: " +danhSachDepartment[i].departmentName);
			System.out.println("\n");
			i++;
		}
//		while : question 13
		i=0;
		while(i<danhSachAccount.length) {
			if(i==1)  {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
			i++;
		}
//		while : question 14
		i=0;
		while(i<3) {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
			i++;
		}
//		while : question 15
		i=0;
		while(i<=20) {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}
//		DO-WHILE
//		Question 17:
//			Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
//			lệnh break, continue
//		DO-WHILE : Question 10
		i=0;
		do {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
			i++;
		}while(i!=danhSachAccount.length);
		
//		DO-WHILE : Question 11
		i=0;
		do {
			System.out.println("Thông tin Department thứ: " +(i+1));
			System.out.println("DepartmentID: "+danhSachDepartment[i].departmentId);
			System.out.println("DepartmentName: " +danhSachDepartment[i].departmentName);
			System.out.println("\n");
			i++;
		}while(i!=danhSachDepartment.length);
//		DO-WHILE : Question 12
		i=0;
		do {
			System.out.println("Thông tin Department thứ: " +(i+1));
			System.out.println("DepartmentID: "+danhSachDepartment[i].departmentId);
			System.out.println("DepartmentName: " +danhSachDepartment[i].departmentName);
			System.out.println("\n");
			i++;
		}while(i!=2);
//		DO-WHILE : Question 13
		i=0;
		do {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
			i++;
			if(i==1) {
				i++;
				continue;
			}
		}while(i!=danhSachAccount.length);
//		DO-WHILE : Question 14
		i=0;
		do {
			System.out.println("Thông tin account thứ: " + (i + 1));
			System.out.println("Email: " + danhSachAccount[i].email);
			System.out.println("FullName: " + danhSachAccount[i].fullName);
			System.out.println("Tên phòng ban: " + danhSachAccount[i].department.departmentName);
			System.out.println("\n");
			i++;
		}while(i!=3);
//		DO-WHILE : Question 15
		i=0;
		do {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}while(i!=21);
	}
}
