package API;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AbstractComponent {

	public static void findDuplicateInArrayList( ArrayList<String> str) {
        System.out.println("=====================RESULT=========================");
       // str.forEach(System.out::println);
 
 
        // 2. get duplicate count using Map
        Map<String, Integer> duplicateCountMap = str
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), company -> 1, Math::addExact)
                        );
 
 
        // 2.1 print Map for duplicate count
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        duplicateCountMap.forEach(
                (key, value) -> System.out.println("Key : " + key + "\t Count : " + value)
                ); 
	}
}
