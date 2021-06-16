package arrayList;

public class MyArrayList {
	private int maxSize = 100;
	
	public int getMaxSize() {
		return maxSize;
	}

	private Object[] arrayList = new Object[maxSize];
	private int n = -1;
	
	public Object get(int i) {
		return arrayList[i];
	}
	
	public Object set(int i, Object e) {
		Object temp = arrayList[i];
		arrayList[i] = e;
		return temp;
	}
	
	public void add(int i, Object e) {
		n++;
		if(n >= maxSize-1) {
			maxSize *= 2;
		}
		for (int idx = 0; idx < n-i; idx++) {
			arrayList[n+1-idx] = arrayList[n-idx];
		}
		arrayList[i] = e;
	}
	
	public Object remove(int i) {
		if(isEmpty()) {
			return "비었습니다.";
		}
		
		Object oElement = arrayList[i];
		for (int idx = 0; idx < n-i; idx++) {
			arrayList[idx] = arrayList[idx+1];
		}
		n--;
		return oElement;
	}
	
	public int size() { return n+1;}
	
	public boolean isEmpty() {
		if(n == -1) return true;
		return false;
	}
}



















