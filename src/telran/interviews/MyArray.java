package telran.interviews;

import java.util.HashMap;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	private T value = null;
	private int size;
	HashMap<Integer , T> mapIndexValue = new HashMap<>();
	
	public MyArray(int size) {
		this.size = size;
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		this.value = value;
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
	
		return isValidIndex(index) ? mapIndexValue.getOrDefault(index, value) : null;
		
	}
	
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		checkIndexWithException(index);
		mapIndexValue.put(index, value);
	}
	
	private boolean isValidIndex(int index) {
	
		return index >= 0 && index < size;
	}
	
	private void checkIndexWithException(int index) {
		if(!isValidIndex(index)) {
			throw new IndexOutOfBoundsException("Index isn't valid");
		}
	}
}