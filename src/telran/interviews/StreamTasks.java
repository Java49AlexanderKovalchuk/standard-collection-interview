package telran.interviews;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

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
	
		
	static public void printDidigitStatistics(int N_NUMB) {
		new Random().ints(N_NUMB, 0, Integer.MAX_VALUE)
		.flatMap(n -> Integer.toString(n).chars()).boxed()
		.collect(Collectors.groupingBy(el -> el, Collectors.counting()))
		.entrySet().stream()
		.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(entry -> System.out.printf("%c: %s\n", entry.getKey(), entry.getValue()));
	}
	
	static public void printDigitStatistics2(int N_NUMB) {
		Integer [][] arr = getArrayNumbers(N_NUMB);
		
		Arrays.stream(arr)
			.flatMap(n -> Arrays.stream(n))	
			.collect(Collectors.groupingBy(el -> el, Collectors.counting()))
			.entrySet().stream()
			.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
			.forEach(entry -> System.out.printf("%s: %s\n", entry.getKey(), entry.getValue()));
			
	}

	private static Integer[][] getArrayNumbers(int N_NUMB) {
		 Integer[][] res = new Random().ints(N_NUMB, 0, Integer.MAX_VALUE).boxed()
				  .map(n -> getArrayFromRand(n)).toArray(Integer[][]::new);
		 
		return res;
	}
	
	private static Integer[] getArrayFromRand (Integer n) {  
		Integer[] ar = new Integer[n.toString().length()];
		int i = 0;
		while (n != 0) {
			int temp = n; 
			temp = temp % 10;
			ar[i++] = temp;
			n = n / 10;
		}
		return ar;
	}

}
 