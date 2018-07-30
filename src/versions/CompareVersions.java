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
		System.out.println("0.1 ? 0.1.1   : " + compareVersions("0.1", "0.1.1"));
		System.out.println("0.0.0 ? 0.0.3 : " + compareVersions("0.0.0", "0.0.3"));
		System.out.println("0 ? 10        : " + compareVersions("0", "10"));
		System.out.println();
		System.out.println("0.1 ? 0.0     : " + compareVersions("0.1", "0.0"));
		System.out.println("1.0 ? 0.1     : " + compareVersions("1.0", "0.1"));
		System.out.println("1.0.1 ? 1.0   : " + compareVersions("1.0.1", "1.0"));
		System.out.println("0.0.3 ? 0.0.0 : " + compareVersions("0.0.3", "0.0.0"));
		System.out.println("10 ? 0        : " + compareVersions("10", "0"));
		System.out.println();
		System.out.println("0.1 ? 0.1     : " + compareVersions("0.1", "0.1"));
		System.out.println("0.0.3 ? 0.0.3 : " + compareVersions("0.0.3", "0.0.3"));
		System.out.println("10 ? 10       : " + compareVersions("10", "10"));
		System.out.println("1.0.0 ? 1.0   : " + compareVersions("1.0.0", "1.0"));
	}

	/**
	 * @param one
	 * @param two
	 * @return
	 */
	public static int compareVersions(String one, String two) throws Exception {
		int result = -2, index;
		if (one != null & two != null && one.replaceAll("[^0-9.]", "").length() > 0 && two.replaceAll("[^0-9.]", "").length() > 0) {
			String[] oneSplit = one.replaceAll("[^0-9.]", "").split("\\.");
			String[] twoSplit = two.replaceAll("[^0-9.]", "").split("\\.");

			// find minimum version sizes to be compared
			int min = Math.min(oneSplit.length, twoSplit.length);

			result = 0;
			// compare till they are of same size
			for (index = 0; index < min; index++) {
				// compare current version and return if they are not same
				if (Integer.valueOf(oneSplit[index]).compareTo(Integer.valueOf(twoSplit[index])) != 0) {
					return Integer.valueOf(oneSplit[index]).compareTo(Integer.valueOf(twoSplit[index]));
				}
			}
			while (index < oneSplit.length) {
				if (Integer.valueOf(oneSplit[index++]) > 0) return 1;
			}
			while (index < twoSplit.length) {
				if (Integer.valueOf(twoSplit[index++]) > 0) return -1;
			}
		}
		return result;
	}

}
