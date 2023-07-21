package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyArray;

class MyArrayTests {

	private static final int LENGTH = 1000;
	private static final int VALUE = 10;
	private static final int OTHER_VALUE = 5;
	MyArray<Integer> array;
		@BeforeEach
		void setUp() throws Exception {
			array = new MyArray<>(LENGTH);
			array.setAll(VALUE);
		}

		@Test
		void testSetAll() {
			for (int i = 0; i < LENGTH; i++) {
				assertEquals(VALUE, array.get(i));
			}
		}

		@Test
		void testSetGet() {
			array.set(0, OTHER_VALUE);
			array.set(LENGTH - 1, OTHER_VALUE);
			int limit = LENGTH - 1;
			for(int i = 1; i < limit; i++) {
				assertEquals(VALUE, array.get(i));
			}
			assertEquals(OTHER_VALUE, array.get(0));
			assertEquals(OTHER_VALUE, array.get(limit));
			array.setAll(OTHER_VALUE);
			for(int i = 0; i < LENGTH; i++) {
				assertEquals(OTHER_VALUE, array.get(i));
			}
			
		}
		
		
//		@Test
//		void exmpl() {
//			System.out.println("jjkjk");
//			HashSet<Integer> hs = new HashSet<>();
//			hs.add(5); hs.add(20); hs.add(5); hs.add(3);
//			System.out.println(hs);
//			//array.createAr();
//			
//			
//		}

}