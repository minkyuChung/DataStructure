package arraydeque;

public interface Queue<E>{
	//큐의 가장 마지막에 요소 추가
	boolean offer(E e);
	//큐의 첫번째 요소 삭제후 요소 반환
	E poll();
	//큐의 첫번째 요소 반환
	E peek();	
}
