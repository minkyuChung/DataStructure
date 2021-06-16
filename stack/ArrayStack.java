package stack;


public class ArrayStack implements Stack{
	private int t = -1;
	static int FULL_STACK = 100;
	private char[] stackArray = new char[FULL_STACK];
	
	@Override
	public int size() { return t+1;	}

	@Override
	public boolean isEmpty() {
		if(t==-1) return true;
		return false;
	}

	@Override
	public char top() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyStackException("Empty stack: cannot top");
		}else
			return stackArray[t];
	}

	@Override
	public void push(char o) throws FullStackException{
		if(t == FULL_STACK-1) {
			throw new FullStackException("Full stack: cannot push");
		}else {
			stackArray[t+1] = o;
			t += 1;
		}
	}

	@Override
	public char pop() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyStackException("Empty stack: cannot pop");
		}
		char temp = stackArray[t];
		if(temp == ')') {
			temp = '(';
		}else if(temp == '(') {
			temp = ')';
		}
		t -= 1;
		return temp;
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









