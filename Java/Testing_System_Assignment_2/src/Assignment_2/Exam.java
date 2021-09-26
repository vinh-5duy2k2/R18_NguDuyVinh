package Assignment_2;

import java.time.LocalDate;

public class Exam {
	short examId;
	String code;
	String title;
	CategoryQuestion categoryQuestion;
	short duration;
	Account creator;
	LocalDate createDate;
	Question[] questions;
}
