package priorityQueue;

import java.awt.Point;

public class TestMain {
	public static void main(String[] args) {
		//1번
		IntComparator c = new IntComparator();
		MyPQ pq = new MyPQ(c);
		
		pq.insert(Integer.valueOf(30), null);
		pq.insert(Integer.valueOf(10), null);
		pq.insert(Integer.valueOf(20), null);
		
		System.out.println((Integer)pq.removeMin().getKey());
		System.out.println((Integer)pq.removeMin().getKey());
		System.out.println((Integer)pq.removeMin().getKey());
		
		//2번
		PointComparator p = new PointComparator();
		MyPQ pq2 = new MyPQ(p);
		
		pq2.insert(new Point(5, 4),'a');
		pq2.insert(new Point(2, 7),'b');
		pq2.insert(new Point(9, 5),'c');
		pq2.insert(new Point(3, 1),'d');
		pq2.insert(new Point(7, 2),'e');
		pq2.insert(new Point(9, 7),'f');
		pq2.insert(new Point(1, 4),'g');
		pq2.insert(new Point(4, 3),'h');
		pq2.insert(new Point(8, 2),'i');
		pq2.insert(new Point(4, 8),'j');
		
		System.out.println("[가까운 순서]");
		MyEntry tmp;	
	    for(int z=0; z<10; z++) {
	        tmp = pq2.removeMin();
	        System.out.println(tmp.getValue()+" ("+(int)((Point) tmp.getKey()).getX()+","+(int)((Point)tmp.getKey()).getY()+")");   
	    }
	    
	    PointComparator2 p2 = new PointComparator2();
	    MyPQ pq3 = new MyPQ(p2);
	      
	    pq3.insert(new Point(5, 4),'a');
		pq3.insert(new Point(2, 7),'b');
		pq3.insert(new Point(9, 5),'c');
		pq3.insert(new Point(3, 1),'d');
		pq3.insert(new Point(7, 2),'e');
		pq3.insert(new Point(9, 7),'f');
		pq3.insert(new Point(1, 4),'g');
		pq3.insert(new Point(4, 3),'h');
		pq3.insert(new Point(8, 2),'i');
		pq3.insert(new Point(4, 8),'j');
	      
	    System.out.println("[멀리 있는 순서]");
	    MyEntry tmp2;	
	    for(int z=0; z<10; z++) {
	        tmp2 = pq3.removeMin();
	        System.out.println(tmp2.getValue()+" ("+(int)((Point) tmp2.getKey()).getX()+","+(int)((Point)tmp2.getKey()).getY()+")");   
	    }
	}
}
