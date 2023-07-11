import java.util.Random;
import java.util.stream.Stream;

public class StreamApp {

	public static void limit() {

		Stream.iterate(5, n -> n * 2).limit(10).forEach(System.out::println);

		Stream.generate(new Random()::nextDouble).map(e -> (e * 10)).limit(10).forEach(System.out::println);
	}

	public static void main(String[] args) {
		limit();
	}
}
