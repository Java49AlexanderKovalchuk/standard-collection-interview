package telran.interviews;

import static telran.interviews.StreamTasks.getRandomPersonsMap;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class StreamTasks {
	static public void displayOccurances(String [] strings)  {
		Arrays.stream(strings)
		.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet().stream().sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
		})
		.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
	}
	
	static public long sumGroups(int[][] groups) {
		return Arrays.stream(groups)
				.flatMapToInt(g -> Arrays.stream(g)).asLongStream()
				.sum();
		
	}
		
	static public void displayOddEvenGrouping(int nNumbers) {
		new Random().ints(nNumbers, 0, Integer.MAX_VALUE).boxed()
		.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd", 
				Collectors.summingLong(x -> x)))
		.forEach((k, v) -> System.out.printf("%s -> %d\n", k, v));
	}
	
		
	
	static public void displayDigitStatistics() {
		int nNumbers = 1_000_000;
		// way 1
		new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
		.flatMap(num -> Integer.toString(num).chars())
		.boxed().collect(Collectors.groupingBy(d -> d, 
				Collectors.counting()))
		.entrySet().stream()
		.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(entry -> System.out.printf("%c: %d\n", entry.getKey(), entry.getValue()));
	}
		
	static public void displayDigitStatistics2() {
		
		int nNumbers = 1_000_000;//way 2
		new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
		.mapToObj(Integer::toString)
		.flatMap(str -> Arrays.stream(str.split("")))
		.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet().stream()
		.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(entry -> System.out.printf("%s: %s\n", entry.getKey(), entry.getValue()));
	
	}
	
	public static Map<Integer, Person> getRandomPersonsMap(int nPersons) {
		return new Random().ints(1000, 2001).distinct()
		.limit(nPersons).mapToObj(id -> new Person(id, "name" + id))
		.collect(Collectors.toMap(p -> p.id(), p -> p, (p, u) -> p, TreeMap::new));
	
	 }
	
}

record  Person(Integer id, String name) {}

 

 