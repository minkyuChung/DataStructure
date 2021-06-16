package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class MyPQ {
	ArrayList<MyEntry> me = new ArrayList<MyEntry>(); 
	Comparator comp = null;
	int capacity = 0;
	MyPQ(Comparator comp){
		this.comp = comp;
	}
	MyPQ(int initialCapacity, Comparator comp){
		this.capacity = initialCapacity;
		this.comp = comp;
	}
	
	public int size() {
		return me.size();
	}
	public boolean isEmpty() {
		if(size()==0)	return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	public MyEntry insert(Object k, Object v) {
		MyEntry m = new MyEntry();
		m.setKey(k);
		m.setValue(v);
		me.add(m);
		for (int i = 0; i < me.size()-1; i++) {
			if(comp.compare(me.get(i).getKey(),k)>=0) {
				for (int j = 1; j < me.size()-i; j++) {
					me.set(me.size()-j,me.get(me.size()-j-1));
				}
				me.set(i, m);
				break;
			}
		}
		return m;
	}
	public MyEntry removeMin() {
		MyEntry m = me.get(0);
		for (int i = 0; i < me.size()-1; i++) {
			me.set(i,me.get(i+1));
		}
		me.set(me.size()-1, null);
		return m;
	}
	public MyEntry min() {
		return me.get(0);
	}
}
