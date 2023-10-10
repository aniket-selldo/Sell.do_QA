package com.selldo.Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class API_Reusable {

	public void findDuplicateInArrayList(ArrayList<String> str) {
		System.out.println("=====================RESULT=========================");
		// str.forEach(System.out::println);
		// 2. get duplicate count using Map
		Map<String, Integer> duplicateCountMap = str.stream()
				.collect(Collectors.toMap(Function.identity(), company -> 1, Math::addExact));
		// 2.1 print Map for duplicate count
		System.out.println("\n2. Map with Key and its duplicate count : \n");
		duplicateCountMap.forEach((key, value) -> System.out.println("Key : " + key + "\t Count : " + value));
	}

	protected static String R(char... arr) {
		return RandomStringUtils.random(1, arr);
	}

	public String DateTime(String time) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(time);// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public  String randomEmail() {
		return "aniket.khandizod+" + Random("AN", 10) + "@sell.do";
	}

	public String randomEmail(String str) {
		return str + "+" + Random("AN", 10) + "@sell.do";
	}

	public String randomPAN() {
		return "" + Random("A", 5) + Random("N", 4) + Random("A", 1);
	}

	public String randomPhone() {
		return " 72345" + Random("N", 5);
	}

	public String Random(int size) {
		return RandomStringUtils.randomAlphabetic(size);
	}

	public String Random(String type, int size) {
		String Return = "";
		switch (type) {
		case "AN":
			Return = RandomStringUtils.randomAlphanumeric(size);
			break;// pX4Mv3KsJU
		case "A":
			Return = RandomStringUtils.randomAlphabetic(size);
			break;// ZLTRqGyuXk
		case "R":
			Return = RandomStringUtils.random(size);
			break;// 嚰险걻鯨贚䵧縓
		case "N":
			Return = RandomStringUtils.randomNumeric(size);
			break;// 3511779161
		default:
			break;
		}
		return Return;
	}

	protected String getDate(int a, String of) {

		String s = "";
		switch (of) {
		case "D":
			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "M":
			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "Y":
			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "m":
			s = new SimpleDateFormat("mm").format(new Date().getTime() + (a * 60000));
			break;
		case "H":
			s = new SimpleDateFormat("HH").format(new Date().getTime() + (a * 3600000));
			break;

		default:
			System.out.println("please select valid input");
			break;
		}
		return s;
	}

	protected void waits(int val) {
		try {
			Thread.sleep(val);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static String prop(String str) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(str);
	}

	public static String DateTime2(String time) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(time);// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static String randomEmail2() {
		String email[] = prop2("Email").split("@");
		String name = email[0];
		String domain = email[1];
		return name + "+" + Random2("AN", 10) + "@" + domain;
	}

	public static String randomEmail2(String str) {
		return str + "+" + Random2("AN", 10) + "@sell.do";
	}

	public static String randomPAN2() {
		String _4th = R('A','B','C','F','G','H','L','J','P','T','F');
		return Random2("A", 3).toUpperCase()+_4th + Random2("A", 1).toUpperCase()+ Random2("N", 4) + Random2("A", 1).toUpperCase();
	}

	public static String randomPhone2() {
		String num = R('7','8','9');
		return " "+num + Random2("N", 9);
	}

	public String Random2(int size) {
		return RandomStringUtils.randomAlphabetic(size);
	}

	public static String Random2(String type, int size) {
		String Return = "";
		switch (type) {
		case "AN":
			Return = RandomStringUtils.randomAlphanumeric(size);
			break;// pX4Mv3KsJU
		case "A":
			Return = RandomStringUtils.randomAlphabetic(size);
			break;// ZLTRqGyuXk
		case "R":
			Return = RandomStringUtils.random(size);
			break;// 嚰险걻鯨贚䵧縓
		case "N":
			Return = RandomStringUtils.randomNumeric(size);
			break;// 3511779161
		default:
			break;
		}
		return Return;
	}

	protected void deZoom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
	}

	protected static String getDate2(int a, String of) {

		String s = "";
		switch (of) {
		case "D":
			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "M":
			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "Y":
			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;

		default:
			System.out.println("please select valid input");
			break;
		}
		return s;
	}

	public static String prop2(String propee) {
		Configurations configs = new Configurations();
		Configuration config = null;
		try {
			config = configs.properties(new File(System.getProperty("user.dir") + "/config.properties"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config.getString(propee);
	}

}
