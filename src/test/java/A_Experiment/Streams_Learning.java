package A_Experiment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class Streams_Learning {
	static List<Person> ls;

	public static boolean Fileter(Person pr) {
		
		if(pr.getAge()<=22) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void M1() {
		Faker fk = new Faker();

		ls = List.of(new Person(fk.firstName(), 22, Gender.Male), new Person(fk.firstName(), 23, Gender.Male),
				new Person(fk.firstName(), 24, Gender.Female), new Person(fk.firstName(), 25, Gender.Female));

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		M1();
		//ls.stream().filter(S -> S.getGen().equals(Gender.Female)).map(S -> S.toString()).forEach(System.out::println);

		//----------------------------------------------------------------------------
		List<Person> lst = ls.stream().filter(S -> S.getGen().equals(Gender.Female)).collect(Collectors.toList());
		
		//----------------------------------------------------------------------------
		List<Person> lst2 = ls.stream().filter(Streams_Learning::Fileter).collect(Collectors.toList());
		lst2.forEach(System.out::println);
		
		//----------------------------------------------------------------------------
		String aru[]= {new Faker().firstName(),new Faker().firstName(),new Faker().firstName()};
		Stream<String> aruu = Arrays.stream(aru);
		System.out.println(aruu.count());
		//----------------------------------------------------------------------------


	}

}
