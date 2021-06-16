package arrayList;

public class TestMain {
	public static void main(String[] args) {
		//Stack
		MyStack stack = new MyStack();
		for (int i = 0; i < 10; i++) {
			stack.push(i+1);
		}
		for (int j = 0; j < 10; j++) {
			System.out.println(stack.pop());
		}
		
		//Queue
		MyQueue queue = new MyQueue();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i+1);
		}
		for (int j = 0; j < 10; j++) {
			System.out.println(queue.dequeue());
		}
	}
}
