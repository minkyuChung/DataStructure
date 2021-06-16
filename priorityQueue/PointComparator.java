package priorityQueue;

import java.awt.Point;
import java.util.Comparator;

public class PointComparator implements Comparator<Point>{
	@Override
	public int compare(Point p1, Point p2) {
        double distance1 = Math.sqrt(Math.pow(p1.x,2)+Math.pow(p1.y,2));
        double distance2 = Math.sqrt(Math.pow(p2.x,2)+Math.pow(p2.y,2));
        if(distance1>distance2) {
	    	return 1;
	    }else if(distance1==distance2){
	        return 0;
	    }else {
	        return -1;
	    }
    }
}
