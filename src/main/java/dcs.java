
public class dcs {

	public static void main(String[] args) {

		long val =1112131418161718L;
		long stack=100;
		long store=0;
		while(val!=0) {
			store=store+(val%stack);
			val/=stack;
		}
		System.out.println(store+19+20);
		
		
		
	}

}
