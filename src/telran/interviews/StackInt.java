package telran.interviews;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {

	private LinkedList<Integer> list;
	private int max;
	
	public StackInt() {
		list = new LinkedList<>();
		max = Integer.MIN_VALUE;
	}
	public void push(int num) {
		list.addFirst(num);  //-30  50 70
		if(num > max) {
			max = num;
		}
		
	} 
	
	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int res = list.removeFirst();
		if(res == max) {
			getMax();
		}
		return res;
		
	}
	private void getMax() {
		max = Integer.MIN_VALUE;
		for(int el: list) {
			if(el > max) {
				max = el;
			}
		}
	}
	
	public  boolean isEmpty() {
		
		return list.isEmpty();  
	}
	
	public int max() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return max;
	}
}
