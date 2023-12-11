package A_Experiment;

enum Gender {
	Male("Male",0), Female("Female",1);

	private final String gen;
	private final int val;

	Gender(String gen,int val) {
		this.gen = gen;
		this.val=val;
	}

	public String getGender() {
		return gen;
	}
	public int getValue() {
		return val;
	}
}

public class Person {

	String name;
	int age;
	Gender gen;

	public Person(String name, int age, Gender gen) {
		super();
		this.name = name;
		this.age = age;
		this.gen = gen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGen() {
		return gen;
	}

	public void setGen(Gender gen) {
		this.gen = gen;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gen=" + gen + "]";
	}

}
