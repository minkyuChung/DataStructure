package arraydeque;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E> {
	
	private static final int DEFAULT_CAPACITY = 64;
	
	private Object[] array;
	private int size;
	
	private int front;
	private int rear;
	
	// 생성자1 (초기 용적 할당을 안할 경우)
	public ArrayDeque() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	 
	// 생성자2 (초기 용적 할당을 할 경우)
	public ArrayDeque(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	private void resize(int newCapacity) {
		 
		int arrayCapacity = array.length; // 현재 용적 크기
	 
		Object[] newArray = new Object[newCapacity]; // 용적을 변경한 배열
	 
		/*
		 * i = new array index 
		 * j = original array 
		 * index 요소 개수(size)만큼 새 배열에 값 복사
		 */
		for (int i = 1, j = front + 1; i <= size; i++, j++) {
			newArray[i] = array[j % arrayCapacity];
		}
	 
		this.array = null;
		this.array = newArray; // 새 배열을 기존 array의 배열로 덮어씌움
	 
		front = 0;
		rear = size;
	 
	}
	@Override
	public boolean offer(E item) {
		return offerLast(item);
	}
	public boolean offerLast(E item) {
		
		// 용적이 가득 찼을 경우 
		if((rear + 1) % array.length == front) {
			resize(array.length * 2);	// 용적을 두 배 늘려준다. 
		}
			
		rear = (rear + 1) % array.length;	// rear을 rear의 다음 위치로 갱신 
			
		array[rear] = item;
		size++;	// 사이즈 1 증가 
			
		return true;
	}
	public boolean offerFirst(E item) {
		// 용적이 가득 찼을 경우
		if((front - 1 + array.length) % array.length == rear) {
			resize(array.length * 2);	// 용적을 두 배 늘려준다. 
		}
			
		array[front] = item;	// front위치는 빈 공간이기 때문에 추가 해준 뒤 front 값을 갱신한다.
		front = (front - 1 + array.length) % array.length;
		size++;	// 사이즈 1 증가
			
		return true;
	}
	@Override
	public E poll() {
		return pollFirst();
	}
	public E pollFirst() {
		if(size == 0) {	// 삭제할 요소가 없을 경우 null 반환 
			return null;
		}
			
		front = (front + 1) % array.length; // front 를 한 칸 옮긴다.
		
		@SuppressWarnings("unchecked")
		E item = (E) array[front];	// 반환할 데이터 임시 저장 
		
		array[front] = null;	// 해당 front의 데이터 삭제
		size--;	// 사이즈 감소 
		
		
		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
				
			// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다. 
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
			
		return item;
	}
	public E remove() {
		return removeFirst();	// 예외는 removeFirst()에서 던져준다.
	}
	 
	public E removeFirst() {
		E item = pollFirst();	// pollFirst()을 호출한다.
		
		if(item == null) {
			throw new NoSuchElementException();
		}
		
		return item;
	}
	public E pollLast() {
		if(size == 0) {	// 삭제할 요소가 없을 경우 null 반환 
			return null;
		}
			
		@SuppressWarnings("unchecked")
		E item = (E) array[rear];	// 반환할 데이터 임시 저장 
			
		array[rear] = null;	// 해당 rear의 데이터 삭제
		
		rear = (rear - 1 + array.length) % array.length; // front 를 한 칸 옮긴다.
		size--;	// 사이즈 감소 
			
			
		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
				
			// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다. 
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
			
		return item;
	}
		
	public E removeLast() {
		E item = pollLast();
			
		if(item == null) {
			throw new NoSuchElementException();
		}
			
		return item;
	}
	@Override
	public E peek() {
		return peekFirst();
	}
	public E peekFirst() {
		// 요소가 없을 경우 null 반환
		if(size == 0) {
			return null;
		}
			
		@SuppressWarnings("unchecked")
		E item = (E) array[(front + 1) % array.length];
		return item;
	}
	public E peekLast() {
		// 요소가 없을 경우 null 반환
		if(size == 0) {
			return null;
		}
			
		@SuppressWarnings("unchecked")
		E item = (E) array[(rear)];
		return item;
	}
	public E element() {
		return getFirst();
	}
		
	public E getFirst() {
		E item = peek();
			
		// 앞의 원소가 null 이라면(size = 0) 예외를 던진다. 
		if(item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}
	public E getLast() {
		E item = peekLast();
	 
		// 앞의 원소가 null 이라면(size = 0) 예외를 던진다.
		if(item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;	
	}
	public boolean contains(Object value) {
		
		int start = (front + 1) % array.length;
			
		/**
		 *  i : 요소 개수만큼만 반복한다. 
		 *  idx : 원소 위치로, 매 회 (idx + 1) % array.length; 의 위치로 갱신 
		 */
		for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
			if(array[idx].equals(value)) {
				return true;
			}
		}
		return false;
	}
	public void clear() {
		
		for(int i = 0; i < array.length; i++) {
			array[i] = null;
		}
			
		front = rear = size = 0;
	}
	public Object[] toArray() {	
		return toArray(new Object[size]);
	}
	
 
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		
		final T[] res;
		// 들어오는 배열의 길이가 덱의 요소 개수보다 작은경우
		if(a.length < size) {
			/*
			 * front가 rear보다 뒤에 있을 경우 (또는 요소가 없을 경우 f==r)
			 *  ______________________
			 *  |  |  |  |  |  |  |  |
			 *  ˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉ
			 *    	f        r
			 */
			if(front <= rear) {
				return (T[]) Arrays.copyOfRange(array, front + 1, rear + 1, a.getClass());
			}
			
			/*
			 * front가 rear보다 앞에 있을 경우
			 *  ______________________
			 *  |  |  |  |  |  |  |  |
			 *  ˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉ
			 *    	r1        f4
			 */
			
			res = (T[]) Arrays.copyOfRange(array, 0, size, a.getClass());
			int rearlength = array.length - 1 - front;	// 뒷 부분의 요소 개수
			
			// 뒷 부분 복사
			if(rearlength > 0) {
				System.arraycopy(array, front + 1, res, 0, rearlength);
			}
			// 앞 부분 복사  
			System.arraycopy(array, 0, res, rearlength, rear + 1);
			
			return res;
		}
		
		
		/*
		 * front가 rear보다 뒤에 있을 경우 (또는 요소가 없을 경우 f==r)
		 *  ______________________
		 *  |  |  |  |  |  |  |  |
		 *  ˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉ
		 *    	f        r
		 */
		if(front <= rear) {
			System.arraycopy(array, front + 1, a, 0, size);
		}
		
		
		/*
		 * front가 rear보다 앞에 있을 경우
		 *  ______________________
		 *  |  |  |  |  |  |  |  |
		 *  ˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉˉ
		 *    	r        f
		 */
		else {
 
			int rearlength = array.length - 1 - front;	// 뒷 부분의 요소 개수
			
			// 뒷 부분 복사
			if(rearlength > 0) {
				System.arraycopy(array, front + 1, a, 0, rearlength);
			}
			// 앞 부분 복사  
			System.arraycopy(array, 0, a, rearlength, rear + 1);
		}
		
		return a;
	}
	
	
	@Override
	public Object clone() {
		
		// super.clone() 은 CloneNotSupportedException 예외를 처리해주어야 한다. 
		try {
			
			@SuppressWarnings("unchecked")
			ArrayDeque<E> clone = (ArrayDeque<E>) super.clone();// 새로운 덱 객체 생성 
		
			// 새로운 덱의 배열도 생성해주어야 함 (내부 객체는 깊은 복사가 되지 않기 때문)
			clone.array = Arrays.copyOf(array, array.length);
			return clone;
		}
		catch(CloneNotSupportedException e) {
			throw new Error(e);
		}
	}
	
	
	public void sort() {
		/**
		 *  Comparator를 넘겨주지 않는 경우 해당 객체의 Comparable에 구현된
		 *  정렬 방식을 사용한다.
		 *  만약 구현되어있지 않으면 cannot be cast to class java.lang.Comparable
		 *  에러가 발생한다.
		 *  만약 구현되어있을 경우 null로 파라미터를 넘기면
		 *  Arrays.sort()가 객체의 compareTo 메소드에 정의된 방식대로 정렬한다.
		 */
		sort();
	}
	
	@SuppressWarnings("unchecked")
	public void sort(Comparator<? super E> c) {
		
		// null 접근 방지를 위해 toArray로 요소만 있는 배열을 얻어 이를 정렬한뒤 덮어씌운다. 
		Object[] res = toArray();
		
		Arrays.sort((E[]) res, 0, size, c);
		
		clear();
		/*
		 *  정렬된 원소를 다시 array에 0부터 차례대로 채운다. 
		 *  이 때 front = 0 인덱스는 비워야 하므로 사실상 1번째 인덱스부터 채워야 한다.
		 *  
		 */
		System.arraycopy(res, 0, array, 1, res.length);	// res 배열을 array에 복사 
		
		this.rear = this.size = res.length;
	}
}

















