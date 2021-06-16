package sorting;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyMergeSort {
	private ArrayList L1;
	private ArrayList L2;
	private Comparator comp;
	int size = 0;
	
	//Constructor
	MyMergeSort(Comparator c) {
		this.comp = c;
	}
	//Implement the following methods
	public void sort(ArrayList l) {
		System.out.println(l);
		L1 = l;
		size = l.size();
		ArrayList sortedList = new ArrayList();
		int count = 0;
		int corpus = 1;				// 뭉치의 크기
		int pair = l.size();	  	// 뭉치의 개수
		
		setComparator(comp, pair);
		
		while(L1.size() > corpus) {
			pair = L1.size() / corpus;
			if(count % 2 == 0) { 	// L2에 입력
				L2 = sortList(L1, corpus, pair);
				sortedList = L2;
			}else {					// L1에 입력
				L1 = sortList(L2, corpus, pair);
				sortedList = L1;
			}	
			corpus *= 2;
			count++;
		}
		System.out.println(sortedList.subList(0, size));
	}
	public Comparator setComparator(Comparator c,int pair) {
		int num = (int)Math.ceil(logB(pair, 2.0));
		for (int i = pair; i < Math.pow(2,num); i++) {
			if(c.getClass().getName().equals("sorting.IntComparator")) {
				L1.add(i,100000);
			}else if(c.getClass().getName().equals("sorting.CharComparator")) {
				L1.add(i,"zzzzzz");
			}
		
		}
		return comp;
	}
	public ArrayList sortList(ArrayList list, int corpus, int pair) {
		ArrayList temp = new ArrayList();
		for (int i = 0; i < pair/2; i++) {
			int left = 0;		// 왼쪽 corpus 인덱스
			int right = 0;		// 오른쪽 corpus 인덱스
			for (int j = 0; j < 2*corpus; j++) {
				if(left == corpus) {				// 왼쪽 값을 모두 넣은 경우
					while(right != corpus) {
						temp.add(2*i*corpus+j, list.get((2*i+1)*corpus+right));	
						right++;
						j++;
					}
					break;
				}else if(right == corpus) {
					while(left != corpus) {
						temp.add(2*i*corpus+j, list.get(2*i*corpus+left));
						left++;
						j++;
					}
					break;
				}else {
					if(comp.compare(list.get(2*i*corpus+left), list.get((2*i+1)*corpus+right)) <= 0) {
						temp.add(2*i*corpus+j, list.get(2*i*corpus+left));
						left++; 			
					}else {
						temp.add(2*i*corpus+j, list.get((2*i+1)*corpus+right));
						right++;
					}
				}
			}
		}
		return temp;
	}
	public static double logB(double x, double base) {
	    return Math.log(x) / Math.log(base);
	}
}