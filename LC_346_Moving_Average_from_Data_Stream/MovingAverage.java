package LC_346_Moving_Average_from_Data_Stream;

import java.util.*;

public class MovingAverage {
     
	Queue<Integer> queue;
	int sum;
	int size;
	
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
    	queue = new LinkedList<>();
    	this.size = size;
    	this.sum = 0;
    }
     
    public double next(int val) {
    	double result = 0;
    	
    	queue.offer(val);
    	sum += val;
    	
    	if(queue.size() <= size) {
    		result = (double)sum / queue.size();
    	}
    	else {
    		sum -= queue.poll();
    		result = (double)sum / queue.size();
    	}
    	
    	return result;
    	
    }
    
    public static void main(String[] args) {
    	MovingAverage m = new MovingAverage(3);
    	System.out.println(m.next(1)); // 1
    	System.out.println(m.next(10)); // (1 + 10) / 2
    	System.out.println(m.next(3)); // (1 + 10 + 3) / 3
    	System.out.println(m.next(5)); // (10 + 3 + 5) / 3
    }
}
