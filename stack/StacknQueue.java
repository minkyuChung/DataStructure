package stack;

import java.util.Scanner;

public class StacknQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//사칙연산 거꾸로 출력
		ArrayStack ar1 = new ArrayStack();
		System.out.print("입력: ");
		String operation = sc.next();
		for (int i = 0; i < operation.length(); i++) {
			ar1.push(operation.charAt(i));
		}
		System.out.print("출력: ");
		while(!ar1.isEmpty()) {
			System.out.print(ar1.pop());
		}
		
		//queue 실행 (예제 3번)
		StackQueue ar2 = new StackQueue();
		String s1 = "abcde";
		for (int i = 0; i < s1.length(); i++) {
			ar2.enqueue(s1.charAt(i));
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(ar2.dequeue());
		}
		System.out.println();
		String s2 = "fghij";
		for (int i = 0; i < s2.length(); i++) {
			ar2.enqueue(s2.charAt(i));
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(ar2.dequeue());
		}
		System.out.println();
		String s3 = "klmno";
		for (int i = 0; i < s3.length(); i++) {
			ar2.enqueue(s3.charAt(i));
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(ar2.dequeue());
		}
		System.out.println();
		while(!ar2.isEmpty()) {
			System.out.print(ar2.dequeue());
		}
	}

}



















