import java.util.HashMap;

public class lEET {

	public static void romanToInt(String s) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);

		for (int i = 0; i < s.length(); i++) {
			
		}
		

	}

	public static void main(String[] args) {
		romanToInt("sdc");
	}
}
