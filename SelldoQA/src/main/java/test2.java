import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;

import com.selldo.Utility.BaseTest;

public class test2 extends BaseTest {

	public static int[] dublicate(String s) {
		System.out.println(s);
		char arr[] = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			boolean bool =set.add(arr[i]);	
			System.out.println((bool? "Unique -> ":"Dupicate -> ")+arr[i]);
		}
		System.out.println();
		int ary[] = { arr.length - set.size(), arr.length, set.size() };
		return (ary);
	}

	public static void main(String[] args) {
		//retriveData(dublicate(random("R", 10000)));
		retriveData(dublicate("khandizod"));


	}

	protected static String random(String choise, int size) {
		String Return = "";
		switch (choise) {
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
	public static void retriveData(int...arr) {
		for (int i = 0; i < arr.length; i++) {
			switch (i) {
			case 0:
				System.out.println("unique -> "+arr[i]);
				break;
			case 1:
				System.out.println("Total -> "+arr[i]);
				break;
			case 2:
				System.out.println("Duplicate -> "+arr[i]);
				break;
			default:
				break;
			}
		}
	}
}
