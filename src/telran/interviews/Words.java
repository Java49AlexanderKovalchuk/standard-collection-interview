package telran.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Words {
	
	private TreeSet<String> treeSetWord = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case insensitive)
	 */
	public boolean addWord(String word) {
		return treeSetWord.add(word);
	}
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {
		
		//SortedSet<String> subSetWord = treeSetWord.subSet(prefix, prefix + Character.toString(126));		
		String lim = getPrefixLimit(prefix);
		SortedSet<String> subSetWord = treeSetWord.subSet(prefix, lim);	
		return Arrays.asList(subSetWord.toArray(String[]::new));
	}
	private String getPrefixLimit(String prefix) {
		char lastPref = prefix.charAt(prefix.length() - 1);
		char limChar = (char) (lastPref + 1);
		return prefix.substring(0, prefix.length() - 1) + limChar;
	}
	
}