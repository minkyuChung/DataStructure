package sorting;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CharComparator implements Comparator{
	public int compare(Object o1, Object o2) {
		
		String str1 = (String)o1;
		str1 = str1.toLowerCase();
		String str2 = (String)o2;
		str2 = str2.toLowerCase();
		
		if(str1.compareTo(str2)>0) {
			return 1;
	    }else if(str1.equals(str2)){
	        return 0;
	    }else {
	        return -1;
	    }
		
	}
}
