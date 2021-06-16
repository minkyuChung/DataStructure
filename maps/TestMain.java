package maps;

public class TestMain {
	public static void main(String[] args) {
		MyHashTable ht = new MyHashTable(13, 0.9);
		System.out.println(ht.size());
		ht.put("100", "google1");
		ht.put("101", "google2");
		ht.put("102", "google3");
		ht.put("103", "google4");
		ht.put("104", "google5");
		ht.put("105", "google6");
		ht.put("106", "google7");
		ht.put("107", "google8");
		ht.put("108", "google9");
		ht.put("109", "google10");
		
		ht.put("110", "google11");
		ht.put("111", "google12");
		// load factor가 기준 값을 넘는 부분에서 rehash가 잘 이루어지는지 확인
		System.out.println(ht.size());
		ht.put("112", "google13");
		ht.put("113", "google14");
		ht.put("114", "google15");
		ht.put("115", "google16");
		ht.put("116", "google17");
		ht.put("117", "google18");
		ht.put("118", "google19");
		ht.put("119", "google20");
		ht.put("120", "google21");
		ht.put("121", "google22");
		ht.put("122", "google23");
		ht.put("123", "google24");
		ht.put("124", "google25");
		System.out.println(ht.size());
		System.out.println(ht.get("107"));
	}
}
