package arrayList;

public class MyStack {
	
	MyArrayList arrList = new MyArrayList();
	
	public int size() { return arrList.size();}

	public boolean isEmpty() { return arrList.isEmpty();}

	public Object top(){
		if(this.isEmpty())	return "비었습니다.";
		return arrList.get(this.size()-1);
	}

	public void push(Object o){
		if(this.size() >= arrList.getMaxSize()-1) {
			throw new FullStackException("Full stack: cannot push");
		}
		arrList.add(this.size(), o);
	}

	public Object pop() {
		if(isEmpty()) {
			throw new EmptyStackException("Empty stack: cannot pop");
		}else 
			return arrList.remove(this.size()-1);
	}
}
@SuppressWarnings("serial")
class FullStackException extends RuntimeException {
	public FullStackException(String s) {
		System.out.println(s);
	}

}
@SuppressWarnings("serial")
class EmptyStackException extends RuntimeException {
	public EmptyStackException(String s) {
		System.out.println(s);
	}
}