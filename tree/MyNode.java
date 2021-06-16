package tree;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class MyNode {
	private Object[] element = new Object[2];
	private MyNode parent;
	private ArrayList children;
	boolean visit = false;
	private int sum;
	
	MyNode(){
		element = null;
		parent = null;
		children = null;
	}
	
	@SuppressWarnings("unchecked")
	MyNode(Object e){
		element[0] = e;
		parent = null;
		children = new ArrayList();
		children.add(null);
		children.add(null);
	}
	MyNode(Object[] e){
		element[0] = e[0];
		element[1] = e[1];
		parent = null;
		children = new ArrayList();
	}
	public Object element() {
		return element[0];
	}
	public Object[] elements() {
		return element;
	}
	
	public MyNode parent() {
		return parent;
	}
	
	public ArrayList children() {
		return children;
	}
	
	public int degree() {
		return children.size();
	}
	
	public void setElement(Object e) {
		this.element[0] = e;
	}
	
	public void setParent(MyNode p) {
		this.parent = p;
	}
	
	public void setChildren(ArrayList c) {
		this.children = c;
	}
	public void setVisited() {
	    visit = true;
	}
	public boolean isVisited() {
		return visit;
	}
	public int getSum() { return sum;}
	public void setSum(int n) {sum += n;}
}






















