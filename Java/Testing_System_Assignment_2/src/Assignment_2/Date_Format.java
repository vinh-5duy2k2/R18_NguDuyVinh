package Assignment_2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;

public class Date_Format {
	public static void main(String[] args) {

//	 	Thêm thông tin vào các bảng
//		Bảng Department;
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

//		Bảng Position
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

//		Bảng Account
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

//		Bảng Group
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

//	 	Bảng TypeQuestion
			TypeQuestion typeQuestion1 = new TypeQuestion();
			typeQuestion1.typeID = 1;
			typeQuestion1.typeName = TypeName.ESSAY;

			TypeQuestion typeQuestion2 = new TypeQuestion();
			typeQuestion2.typeID = 2;
			typeQuestion2.typeName = TypeName.ESSAY;

			TypeQuestion typeQuestion3 = new TypeQuestion();
			typeQuestion3.typeID = 3;
			typeQuestion3.typeName = TypeName.MULTIPLE_CHOISE;

			TypeQuestion typeQuestion4 = new TypeQuestion();
			typeQuestion4.typeID = 4;
			typeQuestion4.typeName = TypeName.MULTIPLE_CHOISE;

//		Bảng CategoryQuestion
			CategoryQuestion categoryQuestion1 = new CategoryQuestion();
			categoryQuestion1.categoryId = 1;
			categoryQuestion1.categoryName = "Java";

			CategoryQuestion categoryQuestion2 = new CategoryQuestion();
			categoryQuestion2.categoryId = 2;
			categoryQuestion2.categoryName = ".NET";

			CategoryQuestion categoryQuestion3 = new CategoryQuestion();
			categoryQuestion3.categoryId = 3;
			categoryQuestion3.categoryName = "SQL";

			CategoryQuestion categoryQuestion4 = new CategoryQuestion();
			categoryQuestion4.categoryId = 1;
			categoryQuestion4.categoryName = "Ruby";

//		Bảng Question
			Question question1 = new Question();
			question1.questionId = 1;
			question1.content = "Cách học ngôn ngữ Java";
			question1.categoryQuestion = categoryQuestion1;
			question1.typeQuestion = typeQuestion1;
			question1.creator = account1;
			question1.createDate = LocalDate.of(2021, 9, 9);

			Question question2 = new Question();
			question2.questionId = 2;
			question2.content = "Cách học ngôn ngữ C#";
			question2.categoryQuestion = categoryQuestion2;
			question2.typeQuestion = typeQuestion2;
			question2.creator = account2;
			question2.createDate = LocalDate.of(2021, 9, 10);

			Question question3 = new Question();
			question3.questionId = 3;
			question3.content = "Cách học SQL";
			question3.categoryQuestion = categoryQuestion3;
			question3.typeQuestion = typeQuestion3;
			question3.creator = account3;
			question3.createDate = LocalDate.of(2021, 9, 11);

			Question question4 = new Question();
			question4.questionId = 4;
			question4.content = "Cách học ngôn ngữ Ruby";
			question4.categoryQuestion = categoryQuestion4;
			question4.typeQuestion = typeQuestion4;
			question4.creator = account4;
			question4.createDate = LocalDate.of(2021, 9, 12);

			Question question5 = new Question();
			question5.questionId = 5;
			question5.content = "Câu hỏi về Java";
			question5.categoryQuestion = categoryQuestion2;
			question5.typeQuestion = typeQuestion2;
			question5.creator = account5;
			question5.createDate = LocalDate.of(2021, 9, 13);

			Question question6 = new Question();
			question6.questionId = 6;
			question6.content = "Câu hỏi về .NET";
			question6.categoryQuestion = categoryQuestion3;
			question6.typeQuestion = typeQuestion3;
			question6.creator = account6;
			question6.createDate = LocalDate.of(2021, 9, 14);

			Question question7 = new Question();
			question7.questionId = 7;
			question7.content = "Câu hỏi về SQL";
			question7.categoryQuestion = categoryQuestion3;
			question7.typeQuestion = typeQuestion3;
			question7.creator = account1;
			question7.createDate = LocalDate.of(2021, 9, 15);

			Question question8 = new Question();
			question8.questionId = 1;
			question8.content = "Câu hỏi về Ruby";
			question8.categoryQuestion = categoryQuestion4;
			question8.typeQuestion = typeQuestion4;
			question8.creator = account2;
			question8.createDate = LocalDate.of(2021, 9, 16);
//		Bảng Answer
			Answer answer1 = new Answer();
			answer1.answerId = 1;
			answer1.content = "Câu trả lời 1";
			answer1.question = question1;
			answer1.isCorrect = true;

			Answer answer2 = new Answer();
			answer2.answerId = 2;
			answer2.content = "Câu trả lời 2";
			answer2.question = question2;
			answer2.isCorrect = false;

			Answer answer3 = new Answer();
			answer3.answerId = 3;
			answer3.content = "Câu trả lời 3";
			answer3.question = question3;
			answer3.isCorrect = true;

			Answer answer4 = new Answer();
			answer4.answerId = 4;
			answer4.content = "Câu trả lời 4";
			answer4.question = question4;
			answer4.isCorrect = false;

			Answer answer5 = new Answer();
			answer5.answerId = 5;
			answer5.content = "Câu trả lời 5";
			answer5.question = question5;
			answer5.isCorrect = true;

			Answer answer6 = new Answer();
			answer6.answerId = 6;
			answer6.content = "Câu trả lời 6";
			answer6.question = question6;
			answer6.isCorrect = true;
//		Bảng Exam
			Exam exam1 = new Exam();
			exam1.examId = 1;
			exam1.code = "CODE1";
			exam1.title = "Đề Thi Số 1";
			exam1.categoryQuestion = categoryQuestion1;
			exam1.duration = 180;
			exam1.creator = account1;
			exam1.createDate = LocalDate.of(2022, 9, 22);

			Exam exam2 = new Exam();
			exam2.examId = 2;
			exam2.code = "CODE2";
			exam2.title = "Đề Thi Số 2";
			exam2.categoryQuestion = categoryQuestion2;
			exam2.duration = 12;
			exam2.creator = account2;
			exam2.createDate = LocalDate.of(2021, 9, 21);

			Exam exam3 = new Exam();
			exam3.examId = 3;
			exam3.code = "CODE3";
			exam3.title = "Đề Thi Số 3";
			exam3.categoryQuestion = categoryQuestion3;
			exam3.duration = 120;
			exam3.creator = account3;
			exam3.createDate = LocalDate.of(2021, 9, 20);

			Exam exam4 = new Exam();
			exam4.examId = 4;
			exam4.code = "CODE4";
			exam4.title = "Đề Thi Số 4";
			exam4.categoryQuestion = categoryQuestion4;
			exam4.duration = 45;
			exam4.creator = account4;
			exam4.createDate = LocalDate.of(2021, 9, 22);

			Exam exam5 = new Exam();
			exam5.examId = 5;
			exam5.code = "CODE5";
			exam5.title = "Đề Thi Số 5";
			exam5.categoryQuestion = categoryQuestion1;
			exam5.duration = 60;
			exam5.creator = account5;
			exam5.createDate = LocalDate.of(2021, 9, 23);

			Exam exam6 = new Exam();
			exam6.examId = 6;
			exam6.code = "CODE6";
			exam6.title = "Đề Thi Số 6";
			exam6.categoryQuestion = categoryQuestion2;
			exam6.duration = 90;
			exam6.creator = account6;
			exam6.createDate = LocalDate.of(2021, 9, 24);

			Question[] questionOfExam1 = { question1, question2, question3 };
			exam1.questions = questionOfExam1;

			Question[] questionOfExam2 = { question2, question3, question4 };
			exam2.questions = questionOfExam2;

			Question[] questionOfExam3 = { question3, question4, question5 };
			exam3.questions = questionOfExam3;

			Question[] questionOfExam4 = { question4, question5, question6 };
			exam4.questions = questionOfExam4;

			Question[] questionOfExam5 = { question5, question6, question7 };
			exam5.questions = questionOfExam5;

			Question[] questionOfExam6 = { question6, question7, question8 };
			exam6.questions = questionOfExam6;

			Exam[] examOfQuestion1 = { exam1 };
			question1.exams = examOfQuestion1;

			Exam[] examOfQuestion2 = { exam1, exam2 };
			question2.exams = examOfQuestion2;

			Exam[] examOfQuestion3 = { exam1, exam2, exam3 };
			question3.exams = examOfQuestion3;

			Exam[] examOfQuestion4 = { exam2, exam3, exam4 };
			question4.exams = examOfQuestion4;

			Exam[] examOfQuestion5 = { exam3, exam4, exam5 };
			question5.exams = examOfQuestion5;

			Exam[] examOfQuestion6 = { exam5, exam6 };
			question6.exams = examOfQuestion6;

			Exam[] examOfQuestion7 = { exam5, exam6 };
			question7.exams = examOfQuestion7;

			Exam[] examOfQuestion8 = { exam6 };
			question8.exams = examOfQuestion8;
//			Question 1:
//				In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//				dạng vietnamese
			Locale locale = new Locale("vi", "VN");

			DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,
					locale);

			String date = dateformat.format(account1.createDate);

			System.out.println(exam1.code + " : " + date);

//			Question 2:
//				In ra thông tin: Exam đã tạo ngày nào theo định dạng
//				Năm – tháng – ngày – giờ – phút – giây
//			Question 3:
//				Chỉ in ra năm của create date property trong Question 2
//			Question 4:
//				Chỉ in ra tháng và năm của create date property trong Question 2
//			Question 5:
//				Chỉ in ra "MM-DD" của create date trong Question 2
	}

}
