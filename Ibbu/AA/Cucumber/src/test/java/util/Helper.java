package util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;


public class Helper {

	public static String getDateAndTimeNow() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now).replace("/", "_").replace(" ", "_").replace(":", "_");
	}

	public static String getSystemDate() {

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String strSystemDate = dateFormat.format(date);

		return strSystemDate.replace("/", ".");
	}

	public String getTempFolderPath() throws IOException {
		File temp = File.createTempFile("temp-file-name", ".tmp");
		String absolutePath = temp.getAbsolutePath();
		String tempFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
		return tempFilePath;
	}

	public static String getRandomValue(String value) {
		Random r = new Random();
		String[] values = {};
		try {
			values = URLDecoder.decode(value, "UTF-8").split("\\|");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values[r.nextInt(values.length)];
	}

	public static String getRandomNumeric(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	public static String getRandomAlphabetic(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	public static String getrandomTestMailId(int length) {
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		String randomEmail = generatedString.toLowerCase() + "@gmail.com";
		return randomEmail;
	}
}

