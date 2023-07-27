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


	@Test     
	void digitStatTest() {
		System.out.println("Statistics of digits occurrences");
		displayDigitStatistics();
		
	}
	
	@Test
	void digitStattest2( ) {
		displayDigitStatistics2();
	}
}
