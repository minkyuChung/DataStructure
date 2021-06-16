package stack;

public class StackQueue implements Queue{
	private int t = -1;
	static int FULL_QUEUE = 100;
	ArrayStack inStack = new ArrayStack();
	ArrayStack outStack = new ArrayStack();
	
	@Override
	public int size() {	return t+1;}

	@Override
	public boolean isEmpty() {
		if(t == -1) {return true;}
		return false;
	}

	@Override
	public char front() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyQueueException("Empty queue: cannot front");
		}else
			return outStack.top();
	}

	@Override
	public void enqueue(char o) throws FullStackException{
		while(!outStack.isEmpty()) {
			inStack.push(outStack.pop());
		}
		if(t == FULL_QUEUE-1) {
			throw new FullQueueException("Full queue: cannot enqueue");
		}else {
			inStack.push(o);
			t += 1;
		}
	}

	@Override
	public char dequeue() {
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
		t -= 1;
		return outStack.pop();
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

