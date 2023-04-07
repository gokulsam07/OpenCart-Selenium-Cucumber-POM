package utilities;

import java.util.Date;

public class CommonUtils {
	public static String getNewEmail() {
		Date date = new Date();
		return "gokul"+date.toString().replace(":", "_").replace(" ", "_")+"@gmail.com";
	}
}
