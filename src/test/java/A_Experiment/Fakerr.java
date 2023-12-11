package A_Experiment;

import java.util.List;

import com.github.javafaker.Faker;

public class Fakerr {

	static Faker faker = new Faker();
	static String streetName = faker.streetName();
	static String number = faker.firstName();
	static String city = faker.cityPrefix();// show (south , port , New , Lake , North)
	static String city2 = faker.citySuffix();// (borough , furt , ton , town ,side)
	static String city3 = faker.streetAddress(true); // Addess true - full with secondary , flase - only primary
	static String city4 = faker.paragraph(10);// Ave 100 charachter paragraph // can add interger to get sentence count
	static String country = faker.sentence(); // return line of sentence approx 5 sentence
	static String country2 = faker.name(); // enter first and last name
	static String country3 = faker.numerify("###"); // number of has will retunr number of numbers
	static String country4 = faker.letterify("#?#"); // add random String at ?
	static String country5 = faker.prefix();// name prefix
	static String country6 = faker.bothify("#?");// work for both string and qution mark
	static List<String> country7 = faker.words(10);// return random words

	public static void M1() {
		country7.stream().forEach(System.out::println);

	}
	
	public static void M2() {
		
	}


	public static void main(String[] args) {
	
	}

}
