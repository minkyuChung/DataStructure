package tree;
 
public class MyBinTree extends MyTree{
	private MyBinNode root = null;
	int sum = 0;
	
	MyBinTree(){ super();}
	
	MyBinTree(Object e){ super(e);}
	
	public boolean isEmpty() {
		if(super.size()==0) return true;
		return false;
	}
	public boolean isRoot(MyBinNode v) {
		if(v.parent() == null) return true;
		return false;
	}
	public boolean isInternal(MyBinNode v) {
		if(hasLeft(v)||hasRight(v)) return true;
		return false;
	}
	public boolean isExternal(MyBinNode v) {
		if(isInternal(v)) return false;
		return true;
	}
	public MyBinNode root() {
		return root;
	}
	public MyBinNode parent(MyBinNode v) {
		return (MyBinNode) v.parent();
	}
	public MyBinNode left(MyBinNode v) {
		return (MyBinNode)v.children().get(0);
	}
	public MyBinNode right(MyBinNode v) {
		return (MyBinNode)v.children().get(1);
	}
	public boolean hasLeft(MyBinNode v) {
		if(v.left()!=null) return true;
		return false;
	}
	public boolean hasRight(MyBinNode v) {
		if(v.right()!=null) return true;
		return false;
	}
	public MyBinNode addRoot(Object e) {
		root = new MyBinNode(e);
		return root;
	}
	public MyBinNode addNode(Object e) {
		MyBinNode node = null;
		
		if(hasLeft((MyBinNode)super.root())&&hasRight((MyBinNode)super.root())){
			System.out.println("Can't add Node because Two Children exist!");
		}else if(hasLeft((MyBinNode)super.root())) {
			node = this.insertRight((MyBinNode)super.root(), e);
		}else if(hasRight((MyBinNode)super.root())) {
			node = this.insertLeft((MyBinNode)super.root(), e);
		}else {
			node = this.insertLeft((MyBinNode)super.root(), e);
		}
		return node;
	}
	public MyBinNode insertLeft(MyBinNode v, Object e) {
		MyBinNode mbn = null;
		
		if(!this.hasLeft(v)) {
			mbn = (MyBinNode)super.setChild(v, 0, e);
		}
		
		return mbn;
	}
	public MyBinNode insertRight(MyBinNode v, Object e) {
		MyBinNode mbn = null;
		
		if(!this.hasRight(v)) {
			mbn = (MyBinNode)super.setChild(v, 1, e);
		}
		
		return mbn;
	}
	public Object replace(MyBinNode v, Object e) {
		Object oElement = v.element();
		v.setElement(e);
		return oElement;
	}
	@SuppressWarnings("unchecked")
	public MyBinNode remove(MyBinNode v) throws TwoChildrenException{
		MyBinNode parent = (MyBinNode)v.parent();
		int idx = 0;
		
		if(this.left(parent)==v) {
			idx = 0;
		}else {
			idx = 1;
		}
		
		if(hasLeft(v)&&hasRight(v)) {			// child가 2개인 경우 예외처리
			throw new TwoChildrenException("cannot remove the node");
		}else if(!(hasLeft(v)||hasRight(v))) {	// child가 없는 경우
			parent.children().set(idx, null);
		}else if(hasLeft(v)) {
			MyBinNode children = (MyBinNode)v.children().get(0);
			parent.children().set(idx, children);
			children.setParent(parent);
		}else {
			MyBinNode children = (MyBinNode)v.children().get(1);
			parent.children().set(idx, children);
			children.setParent(parent);
		}
		return v;
	}
	public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException{
		if(this.isExternal(v)) {
			this.insertLeft(v, t1.element());
			this.insertRight(v, t2.element());
		}else {
			throw new NotExternalException("NotExternalException!!");
		}
	}
	public void preorder(MyBinNode v) {
		System.out.print(v.element()+" ");
		
		if(this.hasLeft(v)) 
			preorder(this.left(v));
		if(this.hasRight(v))
			preorder(this.right(v));
	}
	
	public void inorder(MyBinNode v) {
		if(this.hasLeft(v)) {
			System.out.print("(");
			inorder(this.left(v));
		}
		
		System.out.print(v.element()+"");
		
		if(this.hasRight(v)) {
			inorder(this.right(v));
			System.out.print(")");
		}
	}
	public int postorder(MyBinNode v) {
		int left = 0;
		int right = 0;
		if(this.hasLeft(v)) {
			left=postorder(v.left());
		}
		if(this.hasRight(v)) {
			right=postorder(v.right());
			switch((String)v.element()) {
			case "+":
				v.setElement(left+right);
				break;
			case "-":
				v.setElement(left-right);
				break;
			case "*":
				v.setElement(left*right);
				break;
			case "/":
				if(right ==0) {
					System.out.println("Arithmetic Exceptions!");
					break;
				}
				v.setElement(left/right);
				break;
			}
		}		
		if(v == root)
			System.out.println("="+root.element());
		return (int)v.element();
	}
}

@SuppressWarnings("serial")
class TwoChildrenException extends Exception{
	public TwoChildrenException(String s){
		System.out.println(s);
	}
}
@SuppressWarnings("serial")
class NotExternalException extends Exception{
	public NotExternalException(String s) {
		System.out.println(s);
	}
}















