package classpath;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * Display classpath for the correct program.
 *
 * @author "Jigar Gosalia"
 * 
 */
public class DisplayClassPath {

	public static void main(String[] args) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        System.out.println(Arrays.toString(urls));
	}

}
