package tree;

public class TestMain {
	public static void main(String[] args) {
//		//1번
//		MyTree t1 = new MyTree("Make Money Fast!");
//		MyNode MotiNode = t1.addNode("1.Motivations");
//		t1.addChild(MotiNode, "1.1 Greed");
//		t1.addChild(MotiNode, "1.2 Avidity");
//		MyNode MethodNode = t1.addNode("2.Methods");
//		t1.addChild(MethodNode, "2.1 Stock Fraud");
//		t1.addChild(MethodNode, "2.2 Ponzi Scheme");
//		t1.addChild(MethodNode, "2.3 Bank Robbery");
//		MyNode RefNode = t1.addNode("References");
//		
//		t1.preorder(t1.root());
//		
//		System.out.println("###########################");
//		//2번
//		MyTree t2 = new MyTree("cs16/");
//		
//		MyNode NodeHomeWorks = t2.addNode("homeworks/");
//	    t2.addChild(NodeHomeWorks, "h1c.doc", 3);
//	    t2.addChild(NodeHomeWorks, "h1nc.doc", 2);
//	    MyNode NodePrograms = t2.addNode("programs/");
//	    t2.addChild(NodePrograms, "DDR.java", 10);
//	    t2.addChild(NodePrograms, "Stocks.java", 25);
//	    t2.addChild(NodePrograms, "Robot.java", 20);
//	    t2.addChild(t2.root(), "todo.txt", 1);
//	      
//	    t2.postorder(t2.root());

		//Tree2 실습
		MyBinTree tree = new MyBinTree();
		tree.addRoot("+");
		MyBinNode multi1 = new MyBinNode("*");
		
		MyBinNode num1 = new MyBinNode(2);
		multi1.setLeft(num1);
		MyBinNode minus = new MyBinNode("-");
		multi1.setRight(minus);
		MyBinNode num2 = new MyBinNode(3);
		MyBinNode num3 = new MyBinNode(1);
		minus.setLeft(num2);
		minus.setRight(num3);
		
		MyBinNode multi2 = new MyBinNode("*");
		MyBinNode num4 = new MyBinNode(3);
		MyBinNode num5 = new MyBinNode(2);
		multi2.setLeft(num4);
		multi2.setRight(num5);
		tree.root().setLeft(multi1);
		tree.root().setRight(multi2);
		
		tree.inorder(tree.root());
		tree.postorder(tree.root());
	}
}















