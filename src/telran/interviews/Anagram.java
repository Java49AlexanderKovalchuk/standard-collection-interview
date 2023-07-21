package telran.interviews;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 * anagram is a string containing all symbols from a given word with different order
	 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
	 */
//NOTE: all methods below, including those in the comments, are work 
//   	with the same performance. We can see this fact from test that added 
//   	especially for big string. So for each of three ways: length = 488_890, t ~ 15 s. 
	
	public static boolean isAnagram(String word, String anagram) {

		return getMapFromString(word).entrySet().
				equals(getMapFromString(anagram).entrySet());
	}

//********************other way*************
		
//		boolean res = true;
//		HashMap<String, Integer> mapWord = getMapFromString(word);
//			if(word.length() != anagram.length() || word.isEmpty() || 
//				anagram.isEmpty() || word == null || anagram == null) {
//			res = false;
//			} else {
//			anagram = anagram.toLowerCase();
//			for(int i = 0; i < anagram.length(); i++) {
//				mapWord.merge(anagram.substring(i, i + 1), 
//					1, (a, b) -> a - b);
//			}
//			res = mapWord.values().stream().
//				allMatch(n -> n == 0) ? true: false;
//			}
//			
//			return res;
//	}
		
	private static HashMap<String, Integer> getMapFromString(String str) {
		HashMap<String, Integer> res = new HashMap<>();
		String[] arStr = str.toLowerCase().split("");
			for(String s: arStr) {	
				res.merge(s, 1, (a, b) -> a + b);	
			}
			return res;
	}
	

	// method by webinar:
	private static int initialCounterValue = 0;
//	
//	public static boolean isAnagram(String word, String anagram) {
	
//		if(word.length() != anagram.length() || word.isEmpty()|| 
//				anagram.isEmpty() || word == null || anagram == null) {
//			return false;
//		} 
//		Map<Character, Integer> wordLetters = getMapOfWordLetters(word);
//		char anagramCharArray[] = anagram.toLowerCase().toCharArray();
//		for(char letter: anagramCharArray) {
//			int count = wordLetters.getOrDefault(letter, initialCounterValue);
//			if(count == initialCounterValue) {
//				return false;
//			}
//			wordLetters.put(letter, count - 1);
//			
//		}
//		
//		return true;
//	}
	
	private static Map<Character, Integer> getMapOfWordLetters(String word) {
		Map<Character, Integer> map = new HashMap<>();
		char wordCharArray[] = word.toLowerCase().toCharArray();
		for(char letter: wordCharArray) {
			map.put(letter, map.getOrDefault(letter, initialCounterValue) + 1);
		}
		
		return map;
	}

}
