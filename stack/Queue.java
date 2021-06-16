package stack;

public interface Queue {
	public int size();
	public boolean isEmpty();
	public char front();
	public void enqueue(char o);
	public char dequeue();
}
