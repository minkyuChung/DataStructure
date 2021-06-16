package arrayList;

public class MyQueue {
	
	MyArrayList arrList = new MyArrayList();
	
	public int size() {	return arrList.size();}

	public boolean isEmpty() {
		return arrList.isEmpty();
	}

	public Object front() {
		if(this.isEmpty())	return "비었습니다.";
		return arrList.get(0);
	}

	public void enqueue(Object o) throws FullQueueException{
		if(this.size() >= arrList.getMaxSize()-1) {
			throw new FullQueueException("Full queue: cannot enqueue");
		}else {
			arrList.add(this.size(), o);
		}
	}

	public Object dequeue() throws EmptyQueueException{
		if(isEmpty()) {
			throw new EmptyQueueException("Empty queue: cannot dequeue");
		}else 
			return arrList.remove(0);
		
	}
}
@SuppressWarnings("serial")
class FullQueueException extends RuntimeException {
	public FullQueueException(String s) {
		System.out.println(s);
	}
}
@SuppressWarnings("serial")
class EmptyQueueException extends RuntimeException {
	public EmptyQueueException(String s) {
		System.out.println(s);
	}
}
