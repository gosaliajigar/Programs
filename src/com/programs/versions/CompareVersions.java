package com.programs.versions;

/**
 * Compare versions and return -1, 0 and 1 appropriately.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class CompareVersions {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("0.0 ? 0.1     : " + compareVersions("0.0", "0.1"));
		System.out.println("0.1 ? 1.0     : " + compareVersions("0.1", "1.0"));
		System.out.println("0.0.0 ? 0.0.3 : " + compareVersions("0.0.0", "0.0.3"));
		System.out.println("0 ? 10        : " + compareVersions("0", "10"));
		System.out.println();
		System.out.println("0.1 ? 0.0     : " + compareVersions("0.1", "0.0"));
		System.out.println("1.0 ? 0.1     : " + compareVersions("1.0", "0.1"));
		System.out.println("0.0.3 ? 0.0.0 : " + compareVersions("0.0.3", "0.0.0"));
		System.out.println("10 ? 0        : " + compareVersions("10", "0"));
		System.out.println();
		System.out.println("0.1 ? 0.1     : " + compareVersions("0.1", "0.1"));
		System.out.println("0.0.3 ? 0.0.3 : " + compareVersions("0.0.3", "0.0.3"));
		System.out.println("10 ? 10       : " + compareVersions("10", "10"));
	}

	/**
	 * @param one
	 * @param two
	 * @return
	 */
	public static int compareVersions(String one, String two) throws Exception {
		if (!(one != null && two != null && one.trim() != null && two.trim() != null && one.trim().length() > 0
				&& two.trim().length() > 0)) {
			throw new Exception("Invalid Input");
		}
		String[] oneNumbers = one.trim().split("\\.");
		String[] twoNumbers = two.trim().split("\\.");
		int i = 0;
		while (i < oneNumbers.length || i < twoNumbers.length) {
			if (i < oneNumbers.length && i < twoNumbers.length) {
				if (Integer.parseInt(oneNumbers[i]) < Integer.parseInt(twoNumbers[i])) {
					return -1;
				} else if (Integer.parseInt(oneNumbers[i]) > Integer.parseInt(twoNumbers[i])) {
					return 1;
				}
			} else if (i < oneNumbers.length) {
				if (Integer.parseInt(oneNumbers[i]) != 0) {
					return 1;
				}
			} else if (i < twoNumbers.length) {
				if (Integer.parseInt(twoNumbers[i]) != 0) {
					return -1;
				}
			}
			i++;
		}
		return 0;
	}
}
