package telran.interviews.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.interviews.StreamTasks.*;

class StreamTasksTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void displayOccurancesTest() {
		String[] strings = {"lmn", "ab", "lmn", "c", "ab", "a", "lmn", "aaa"};
		displayOccurances(strings);
		
	}
	
	@Test
	@Disabled
	void displayOddEvenGroupingTest() {
		displayOddEvenGrouping(20);
	}


	@Test     //printing for 1-st way's method
	void printDigitStatTest() {
		System.out.println("Statistics of digits occurrences, WAY1:");
		printDidigitStatistics(1_000_000);
		
		
  	}
	@Test     //printing for 2-nd way's method
	void printDigitStatTest2() {
		System.out.println("\nStatistics of digits occurrences, WAY2:");
		printDigitStatistics2(1_000_000);
	}
		
}
