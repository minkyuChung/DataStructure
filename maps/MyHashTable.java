package maps;

import java.util.ArrayList;

public class MyHashTable {
	//��ü ��Ŷ�� ��� �迭
	private ArrayList<ArrayList<StudentInfo>> bucketArray;
	// �迭�� ũ��
	private int bucketCapacity;
	// ������ ��/�迭�� ũ��
	private double loadFactor;
	// loadfactor�� ���ذ�
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
	// division����� �̿��� key -> hash������ ��ȯ�ϴ� �Լ�
	private int hashFunc(String k) {
		int idx = Integer.parseInt(k) % bucketCapacity;
		return idx;
	}
	// loadfactor�� ���� ���� �������� �� ��Ŷ�� ũ�⸦ 2��� ������Ű�� �Լ�
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
		// hash���� ���� ��� separate chaining�� �ϱ� ���� chain�̶�� arraylist�� ����� collision �ذ�
		bucketArray.get(hashFunc(k)).add(student);
		size++;
		// load factor�� ��� ����
		loadFactor = size/(float)bucketCapacity;
		// load factor�� ������ ������ capacity�� 2��� ����
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
		// load factor�� ��� ����
		loadFactor = this.size()/(float)bucketCapacity;
		return stu.getStudentName();
	}
}
