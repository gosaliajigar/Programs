package com.programs.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

/**
 *
 * This class shows different ways to read complete file contents to String
 *
 * @author "Jigar Gosalia"
 *
 */
public class ReadFileToString {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
		String fileName = "C:/Windows/System32/drivers/etc/hosts";
		String contents = readUsingApacheCommonsIO(fileName);
		System.out.println(contents);
		System.out.println(contents.length());
		System.out.println("-------------------------------------");
		contents = readUsingBufferedReader(fileName);
		System.out.println(contents);
		System.out.println(contents.length());
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static String readUsingBufferedReader(final String fileName)
			throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line).append(
					System.getProperty("line.separator"));
		}
		// delete the last line-separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();
		return stringBuilder.toString();
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static String readUsingApacheCommonsIO(final String fileName)
			throws IOException {
		return FileUtils.readFileToString(new File(fileName),
				Charset.defaultCharset());
	}
}
