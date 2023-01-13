package c14.stream;

import java.util.stream.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TestStream {

	public static void main(String[] args) {
		useMap();
	}

	public static void useMap() {
		List<Integer> number = Arrays.asList(1, 9, 3, 5, 12, 7);

		List<Integer> square = number.stream().map(x -> x * x).toList();

		System.out.println(square);
	}
}
