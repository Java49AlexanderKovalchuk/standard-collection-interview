package telran.interviews;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackIntTest {
StackInt stackInt = new StackInt();
	
@BeforeEach
	void setUp() throws Exception {
		stackInt.push(70);
		stackInt.push(50);
		stackInt.push(-30);
		stackInt.push(100);

	}

	@Test
	void isEmptyTest() {
		assertFalse(stackInt.isEmpty());
	}
	
	@Test
	void popMaxTest() {
		assertEquals(100, stackInt.pop());  //70, 50, -30, 100
		assertEquals(70, stackInt.max());
		assertEquals(-30, stackInt.pop());
		assertEquals(70, stackInt.max());
		assertEquals(50, stackInt.pop());
		assertEquals(70, stackInt.max());
		assertEquals(70, stackInt.pop());
		
		assertTrue(stackInt.isEmpty());
		assertThrowsExactly(NoSuchElementException.class,
				() -> stackInt.pop());
		assertThrowsExactly(NoSuchElementException.class,
				() -> stackInt.max());
	}
	
}
