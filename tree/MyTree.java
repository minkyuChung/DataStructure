package tree;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class MyTree {
	private MyNode root;
	private int size;
	
	MyTree(){
		root = null;
		size = 0;
	}
	
	MyTree(Object e){
		root = new MyNode(e);
		size = 1;
	}
	
	public int size() {
		return this.size;
	}
	
	public MyNode root() {
		return this.root;
	}
	
	public ArrayList children(MyNode v) {
		return v.children();
	}
	
	public boolean isExternal(MyNode v) {
		return v.children().isEmpty();
	}
	
	public MyNode addRoot(Object e) {
		MyNode temp = this.root;
		this.root = new MyBinNode(e);
		size = 1;
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	public MyNode addNode(Object e) {
		MyNode node = new MyNode(e);
		node.setParent(root);
		root.children().add(node);
		size++;
		return node;
	}
	
	@SuppressWarnings("unchecked")
	public MyNode addChild(MyNode v, Object e) {
		MyNode node = new MyNode(e);
		node.setParent(v);
		v.children().add(node);
		size++;
		return node;
	}
	@SuppressWarnings("unchecked")
	public MyNode addChild(MyNode v, Object e1, Object e2) {
		Object[] e = {e1, e2};
		MyNode node = new MyNode(e);
		node.setParent(v);
		v.children().add(node);
		size++;
		return node;
	}
	@SuppressWarnings("unchecked")
	public MyNode addChild(MyNode v, int i, Object e) {
		MyNode node = new MyNode(e);
		node.setParent(v);
		v.children().add(i, node);
		size++;
		return v;
	}

	@SuppressWarnings("unchecked")
	public MyNode setChild(MyNode v, int i, Object e) {
		v.children().set(i, e);
		return v;
	}
	
	public MyNode removeChild(MyNode v, int i) {
		v.children().remove(i);
		size--;
		return v;
	}
	public void preorder(MyNode t) {
		if(t==root) {
			System.out.println(t.element());
	        t.setVisited();
	    }
	    if(!t.children().isEmpty()) {
	        for(int i=0; i<t.children().size(); i++) {
	        	if(t.isVisited()==false) {
	        		System.out.println(" "+t.element());
	        		t.setVisited();
	            }
	            preorder((MyNode)t.children().get(i));
	        }
	    }else {
	    	t.setVisited();
	    	if(t.parent()==root) System.out.println(" "+t.element());
	    	else System.out.println("  "+t.element());
	    }
	}
	   
	public void postorder(MyNode t) {
	    if(!t.children().isEmpty()) {
	    	for(int i=0; i<t.children().size(); i++) {
	    		postorder((MyNode)t.children().get(i));
	    	}
	        if(t.isVisited()==false) {
	            t.setVisited();
	            if(t.parent() != null) {
	            	t.parent().setSum(t.getSum());
	            }
	            System.out.println(t.elements()[0]+" = "+t.getSum()+"KB");
	        }
	    }else {
	    	t.setVisited();
	    	t.parent().setSum((int)t.elements()[1]);
	    }
	}
}





















