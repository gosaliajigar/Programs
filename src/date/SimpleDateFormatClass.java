package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * SimpleDateFormat Example
 * @link http://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
 *
 * @author "Jigar Gosalia"
 *
 */
public class SimpleDateFormatClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Scanner scanner = new Scanner(System.in);
		String stringDate = "";
		while (stringDate.length() != 8) {
			System.out
					.println("Input date should be atleast 8 characters (yyyyMMdd) ... ");
			stringDate = scanner.nextLine();
		}
		scanner.close();

		Date parsedDate;
		try {
			parsedDate = simpleDateFormat.parse(stringDate);
			if (!simpleDateFormat.format(parsedDate).equals(stringDate)) {
				System.out.printf("Input date %s is not in format yyyyMMdd\n", stringDate);
			} else {
				System.out.println("Parsed Date : " + parsedDate);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
