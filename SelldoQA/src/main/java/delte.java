
public class delte {

	public static void main(String[] args) {
		String key ="0f78d52f936023a9f66df801c2a311b5";
		
		System.out.println(key.length());
		System.out.println(key.toUpperCase());
		System.out.println("-> "+key.replaceAll("[0-9]", "a"));
		System.out.println(key.replaceAll("[0-9]", ""));
		System.out.println(key.replaceAll("[a-z]", ""));
		System.out.println("-> "+key.replaceAll("[a-z]", "0"));
		StringBuffer sb = new StringBuffer(key);
		System.out.println(sb.reverse());


		

	}
}
