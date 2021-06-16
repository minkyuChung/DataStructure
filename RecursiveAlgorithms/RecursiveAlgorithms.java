package recursive;

import java.math.BigInteger;

public class RecursiveAlgorithms {
	
	public static void main(String[] args) {				//201610604 Á¤ ¹Î±Ô
		//power
		long result = power(5,16);
		System.out.println(result);
		
		
		//binary sum
		int[] A = new int[100];
		for (int i = 0; i < A.length; i++) {
			A[i] = i+1;
		}
		System.out.println(binarySum(A,0,100));
		
		
		//linear fibonacci
		System.out.print("[");
		for (int i = 0; i < 99; i++) {
			System.out.print(linearFib(i+1)[0].toString()+", ");
		}
		System.out.print(linearFib(100)[0].toString());
		System.out.print("]");
	}
	
	public static long power(int x, int n) {
		long y = 0;
		if(n==0) {
			return 1;
		}else if(n % 2 == 1) {
			y = power(x, (n-1)/2);
			return x*y*y;
		}else {
			y = power(x, n/2);
			return y*y;
		}
	}
	
	public static int binarySum(int[] A, int i, int n) {
		if(n==1) {
			return A[i];
		}else if(n % 2 == 1) {
			return binarySum(A, i, n/2)+binarySum(A, i+n/2, n/2+1);
		}else {
			return binarySum(A, i, n/2)+binarySum(A, i+n/2, n/2);
		}
	}

	public static BigInteger[] linearFib(int n) {
		BigInteger A[] = new BigInteger[2];
		BigInteger B[] = new BigInteger[2];
		if(n<=1) {
			A[0] = BigInteger.valueOf(n);
			A[1] = BigInteger.valueOf(0);
			return A;
		}else {
			B = linearFib(n-1);
			A[0] = B[0].add(B[1]);
			A[1] = B[0];
			return A;
		}
	}
}





















