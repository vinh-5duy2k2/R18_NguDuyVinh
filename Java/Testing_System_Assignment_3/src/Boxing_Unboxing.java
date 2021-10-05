
public class Boxing_Unboxing {
	public static void main(String[] args) {
//	Quesion 1:
		int luong = 5000;
		float convertLuong = (float) luong;
		System.out.printf("Lương đã convert: %.2f", convertLuong);
		System.out.println("\n");
//	Question 2:
		String value1 = "1234567";
		Integer convertValue1 = new Integer(value1);
		System.out.println("Value1 đã convert: " +Integer.valueOf(value1));
//	Question 3:
		Integer value2 = new Integer("1234567");
		int convertValue2 = value2;
		System.out.println("Value2 đã convert: " +convertValue2);
		
	}
}
