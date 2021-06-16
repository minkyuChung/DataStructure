package sorting;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class IntComparator implements Comparator{
	public int compare(Object o1, Object o2) {
		int num1 = (int)o1;
		int num2 = (int)o2;
		if(num1>num2) {
			return 1;
	    }else if(num1==num2){
	        return 0;
	    }else {
	        return -1;
	    }
	}
}
