package versions;

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
		System.out.println("0.0.0 ? 0.0.3 : "
				+ compareVersions("0.0.0", "0.0.3"));
		System.out.println("0 ? 10        : " + compareVersions("0", "10"));
		System.out.println();
		System.out.println("0.1 ? 0.0     : " + compareVersions("0.1", "0.0"));
		System.out.println("1.0 ? 0.1     : " + compareVersions("1.0", "0.1"));
		System.out.println("0.0.3 ? 0.0.0 : "
				+ compareVersions("0.0.3", "0.0.0"));
		System.out.println("10 ? 0        : " + compareVersions("10", "0"));
		System.out.println();
		System.out.println("0.1 ? 0.1     : " + compareVersions("0.1", "0.1"));
		System.out.println("0.0.3 ? 0.0.3 : "
				+ compareVersions("0.0.3", "0.0.3"));
		System.out.println("10 ? 10       : " + compareVersions("10", "10"));
	}

	/**
	 * @param one
	 * @param two
	 * @return
	 */
	public static int compareVersions(String one, String two) throws Exception {
		int result = -2;
		String[] oneSplit = one.split("\\.");
		String[] twoSplit = two.split("\\.");

		// find minimum version sizes to be compared
		int min = ((oneSplit.length <= twoSplit.length) ? oneSplit.length : twoSplit.length);

		if (one != null & two != null && one.length() > 0 && two.length() > 0) {
			// compare till they are of same size
			for (int index = 0; index < min; index++) {
				// compare current version and return if they are not same
				if (Integer.valueOf(oneSplit[index]).compareTo(Integer.valueOf(twoSplit[index])) != 0) {
					return Integer.valueOf(oneSplit[index]).compareTo(Integer.valueOf(twoSplit[index]));
				} else {
					// they are equal till this iteration
					result = 0;
				}
			}
			// if they are equal and their sizes are different then the greater size version is greater
			if (result == 0 && oneSplit.length != twoSplit.length) {
				return ((oneSplit.length > twoSplit.length) ? 1 : -1);
			}
		}
		return result;
	}

}
