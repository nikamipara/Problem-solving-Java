package LeanStartUpBar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utills {
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"HH:mm:ss a");

	public static String getMealName(int id) {
		switch (id) {
		case 1:
			return "Sandwich";
		case 2:
			return "Coffie";
		case 3:
			return "Cerial";
		case 4:
			return "Pizza";
		default:
			return "";
		}
	}

	public static String getCurrentTime() {
		return Utills.dateFormat.format(new Date());
	}
}
