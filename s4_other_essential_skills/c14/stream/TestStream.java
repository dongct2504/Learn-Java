package c14.stream;

import java.util.stream.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TestStream {

	public static void main(String[] args) {
		// useMap();
		// useFilter();
		// useSorted();
		// returnSet();
		// useForEach();
		useReduce();
	}

	public static void useMap() {
		List<Integer> numbers = Arrays.asList(1, 9, 3, 5, 12, 7);

		List<Integer> square = numbers.stream()
				.map(x -> x * x)
				.collect(Collectors.toList());

		System.out.println(square);
	}

	public static void useFilter() {
		List<String> names = Arrays.asList("Dong", "Tay", "Nam", "Bac");

		List<String> nameFilter = names.stream()
				.filter(n -> n.startsWith("D") || n.startsWith("N"))
				.collect(Collectors.toList());

		System.out.println(nameFilter);
	}

	public static void useSorted() {
		List<String> names = Arrays.asList("Dong", "Tay", "Nam", "Bac");

		List<String> nameSorted = names.stream()
				.sorted()
				.collect(Collectors.toList());

		System.out.println(nameSorted);
	}

	public static void returnSet() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 5, 3, 1, 9, 3);

		Set<Integer> squareNoDuplicate = numbers.stream()
				.map(x -> x * x)
				.collect(Collectors.toSet());
		
		System.out.println(squareNoDuplicate);
	}

	public static void useForEach() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 5, 3, 1, 9, 3);

		numbers.stream()
				.forEach(n -> System.out.print(n + " "));
	}

	public static void useReduce() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 5, 3, 1, 9, 3);

		int even = numbers.stream()
				.filter(n -> n % 2 == 0)
				.reduce(0, (ans, i) -> ans + i);
		
		System.out.println(even);
	}
}
