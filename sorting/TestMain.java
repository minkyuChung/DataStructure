package sorting;

import java.util.ArrayList;
import java.util.Random;

public class TestMain {
	
	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	public static void main(String[] args) {
		System.out.println("==============Integer Sort==============");
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < 20; i++) {
			Random r = new Random();
			list.add(i,r.nextInt(101));	
		}
		
		IntComparator ic = new IntComparator();
		
		MyMergeSort ms1 = new MyMergeSort(ic);
		ms1.sort(list);
		
		System.out.println("\n==============String Sort==============");
		
		
		String txt = "In computer science, a data structure is a data organization, management, and storage" +
				"format that enables efficient access and modification More precisely, a data structure is a" + 
				"collection of data values, the relationships among them, and the functions or operations" + 
				"that can be applied to the data";
		
		String[] temp = null;
		txt = txt.replace(",", "");
		temp = txt.split(" ");
		ArrayList word = new ArrayList();
		
		for (int i = 0; i < temp.length; i++) {
			word.add(temp[i]);
		}
		
		CharComparator cc = new CharComparator();
		MyMergeSort ms2 = new MyMergeSort(cc);
		ms2.sort(word);
	}
}
















