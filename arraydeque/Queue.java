package arraydeque;

public interface Queue<E>{
	//ť�� ���� �������� ��� �߰�
	boolean offer(E e);
	//ť�� ù��° ��� ������ ��� ��ȯ
	E poll();
	//ť�� ù��° ��� ��ȯ
	E peek();	
}
