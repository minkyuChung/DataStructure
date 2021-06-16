package maps;

import java.util.ArrayList;

public class MyHashTable {
	//전체 버킷을 담는 배열
	private ArrayList<ArrayList<StudentInfo>> bucketArray;
	// 배열의 크기
	private int bucketCapacity;
	// 데이터 수/배열의 크기
	private double loadFactor;
	// loadfactor의 기준값
	double standard;
	private int size=0;
	
	MyHashTable(int initialCapacity){
		this.bucketCapacity = initialCapacity;
		bucketArray = new ArrayList<ArrayList<StudentInfo>>();
		for (int i = 0; i < initialCapacity; i++) {
			ArrayList<StudentInfo> chain = new ArrayList<>(); 
			bucketArray.add(i, chain);
		}
	}
	MyHashTable(int initialCapacity, double loadFactor){
		this.bucketCapacity = initialCapacity;
		bucketArray = new ArrayList<ArrayList<StudentInfo>>();
		for (int i = 0; i < initialCapacity; i++) {
			ArrayList<StudentInfo> chain = new ArrayList<>(); 
			bucketArray.add(i, chain);
		}
		this.standard = loadFactor;
	}
	// division방법을 이용해 key -> hash값으로 변환하는 함수
	private int hashFunc(String k) {
		int idx = Integer.parseInt(k) % bucketCapacity;
		return idx;
	}
	// loadfactor가 기준 값에 도달했을 때 버킷의 크기를 2배로 증가시키는 함수
	private void rehash(int capacity) {
		bucketCapacity = 2*capacity;
		for (int i = capacity; i < bucketCapacity; i++) {
			ArrayList<StudentInfo> chain = new ArrayList<>(); 
			bucketArray.add(i, chain);
		}
	}
	public double getLoadFactor() {
		return loadFactor;
	}
	public int size() {
		return bucketArray.size();
	}
	public String get(String k) {
		int idx = -1;
		for (int i = 0; i < bucketArray.get(hashFunc(k)).size(); i++) {
			if(bucketArray.get(hashFunc(k)).get(i).getStudentID()==k) {
				idx = i;
				break;
			}
		}
		return bucketArray.get(hashFunc(k)).get(idx).getStudentName();
	}
	public void put(String k, String v) {
		StudentInfo student = new StudentInfo();
		student.setStudentID(k);
		student.setStudentName(v);
		// hash값이 같은 경우 separate chaining을 하기 위해 chain이라는 arraylist를 만들어 collision 해결
		bucketArray.get(hashFunc(k)).add(student);
		size++;
		// load factor를 계속 갱신
		loadFactor = size/(float)bucketCapacity;
		// load factor가 기준을 넘으면 capacity를 2배로 증가
		if(loadFactor > standard) {
			rehash(bucketCapacity);
		}
	}
	public String remove(String k) {
		StudentInfo stu = null;
		for (int i = 0; i < bucketArray.get(hashFunc(k)).size(); i++) {
			if(bucketArray.get(hashFunc(k)).get(i).getStudentID()==k) {
				stu = bucketArray.get(hashFunc(k)).remove(i);
				break;
			}
		}
		size--;
		// load factor를 계속 갱신
		loadFactor = this.size()/(float)bucketCapacity;
		return stu.getStudentName();
	}
}
