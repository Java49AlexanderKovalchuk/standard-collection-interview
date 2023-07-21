package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.interviews.Anagram.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AnagramTests {
	String word = "yellow";
	String bigStr = "";
	
	@Test
	void testAnagramTrue() {
		assertTrue(isAnagram(word, "loweyl"));
		assertTrue(isAnagram(word, "elolyw"));
		assertTrue(isAnagram(word, "wolley"));
		assertTrue(isAnagram(word, "loleyw"));
		assertTrue(isAnagram(word, "yellow"));
		
	}
	
	@Disabled
	@Test	
	void testAnagramForBigString() {
		for(int i = 0; i < 100_000; i++) {
		bigStr += i; 
		}
		System.out.println("length of bigSTr = " + bigStr.length());
		assertTrue(isAnagram(bigStr, bigStr));
	}
	
	@Test
	void testAnagramFalse() {
		assertFalse(isAnagram(word,""));
		assertFalse(isAnagram(word, "yellob"));
		assertFalse(isAnagram(word,"yello"));
		assertFalse(isAnagram(word,"yelllo"));
		
	}
	
}