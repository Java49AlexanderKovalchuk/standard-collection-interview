package telran.util.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.Words;


class WordsTest {

	String words[]= {"abcdef","ab123","aaa","ab","ablmn","abbbb",
			"a", "ABd","bbb", "B12", "*/", };
	String wordsStartB[] = {"B12", "bbb"};
	String wordsStartAB[] = {"ab","ab123","abbbb","abcdef","ABd","ablmn"};
	String wordsStartABC[] = {"abcdef"};
	String wordsStartAsteric[] = {"*/"};
	Words elasticSearch;
		@BeforeEach
		void setUp() throws Exception {
			elasticSearch = new Words();
			for(String word: words) {
				elasticSearch.addWord(word);
			}
				
				
		}

		@Test
		void test() {
			assertArrayEquals(wordsStartABC,
					elasticSearch.getWordsByPrefix("abc").toArray(String[]::new));
			assertArrayEquals(wordsStartB, elasticSearch.getWordsByPrefix("B").toArray(String[]::new));
			assertArrayEquals(wordsStartAB, elasticSearch.getWordsByPrefix("ab").toArray(String[]::new));
			assertArrayEquals(wordsStartAsteric, elasticSearch.getWordsByPrefix("*").toArray(String[]::new));
			
		}
		@Test
		void check() {
			System.out.println("as".charAt(1));
			char q = "df".charAt(0);
			System.out.println(q);
			String prefix = "a";
			System.out.println(prefix.substring(0, prefix.length() - 1));
		}
		
}