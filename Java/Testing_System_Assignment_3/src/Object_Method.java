import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Object_Method {
	public static void main(String[] args) {
		List<Department> listDept = new ArrayList<Department>();
		listDept.add(new Department(1, "Waiting Room"));
		listDept.add(new Department(2, "Boss of director"));
		listDept.add(new Department(3, "Manager"));
		listDept.add(new Department(4, "Accounting"));
		listDept.add(new Department(5, "Sale"));
//		1:
		System.out.println("Department 1: ");
		outputDept(listDept);
		System.out.println("\n");
//		2:
		System.out.println("Danh sách Department: ");
		outputAllDept(listDept);
		System.out.println("\n");
//		3:
		int pointer = outputPointer(listDept);
		System.out.println("Địa chỉ Department 1: " +pointer);
		System.out.println("\n");
//		4:
		boolean check1 = checkDeptName(listDept);
		System.out.println("Kiểm tra tên Department 1: " +check1);
		System.out.println("\n");
//		5:
		boolean check2 = checkDept(listDept);
		System.out.println("So sánh Dept1 và Dept2: " +check2);
		System.out.println("\n");
//		6:
		System.out.println("Sắp xếp tên theo thứ tự ABC: ");
		sapXepDanhSachDept(listDept);
		System.out.println("\n");
	}

// Question 1
	public static void outputDept(List<Department> listDept) {
		System.out.println(listDept.get(0).toString());
	}

//	Question 2
	public static void outputAllDept(List<Department> listDept) {
		for (Department dept : listDept) {
			System.out.println(dept.toString());
		}
	}

//	Question 3
	public static int outputPointer(List<Department> listDept) {
		return listDept.get(0).hashCode();
	}

//	Question 4
	public static boolean checkDeptName(List<Department> listDept) {
		return listDept.get(0).name.equals("Phòng A");
	}

//	Question 5
	public static boolean checkDept(List<Department> listDept) {
		return listDept.get(0).equals(listDept.get(1));

	}

//	Question 6
	public static void sapXepDanhSachDept(List<Department> listDept) {
			Collections.sort(listDept);
			for (Department department : listDept) {
				System.out.println(department.name);
			}

	}
}
