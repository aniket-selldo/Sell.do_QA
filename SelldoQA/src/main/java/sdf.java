class demo {
	private String name1;
	private String name2;
	
	public demo(String name1,String name2) {
		this.name1=name1;
		this.name2=name2;
	}
}
class demo2 {
	private String name1;
	private String name2;
	
	public demo2(String name1,String name2) {
		this.name1=name1;
		this.name2=name2;
	}
}

public class sdf {

	public static void main(String[] args) {
		
		System.out.println(new demo("Aniket","Anu")); //object return any random String
		System.out.println(new demo("Aniket","Anu").hashCode()); //Hash code return integer value
		
		//----------------------------------------------
		
		System.out.println(new demo("Aniket","Anu").equals(new demo2("Aniket","Anu")));
		System.out.println(new demo("Aniket","Anu").hashCode()+" "+new demo2("Aniket","Anu").hashCode());
		
		//-------------------------------------------------
		
		String s = "Aniket";
		String s1 = new String("Aniket");
		
		System.out.println(s.equals(s1));
		System.out.println(s.hashCode()==s1.hashCode());
		
		Object o = "Aniket";

		System.out.println(s1==o);
		System.out.println(s1.equals(o));
		System.out.println(o.hashCode()==s1.hashCode());
		
		
		System.out.println(s.getClass().getName());
		System.out.println(o.getClass().getTypeName());
		System.out.println(s.getClass().getClasses());
		System.out.println(s.getClass().getComponentType());
		
		}

}
