package Baekjoon.finished;

import java.util.Scanner;

public class fibonacci_1003 {

	static int o, z;
	
	public static void main(String[] args) {
		
		int num, num2;
		
		Scanner input = new Scanner(System.in);
		
		num=input.nextInt();
		
		
		for(int i=0; i<num; i++) {
			o=0;
			z=0;
			num2= input.nextInt();
			if(num2<0 || num2>40)
				return;
			fibo(num2);
			
			System.out.println(z+" "+o);
		}
	}

	static void fibo(int n) {
		
		if(n==0) {
			z++;
			return;
		}
		else if(n==1) {
			o++;
			return;
		}
		
		int[] bae = new int[n+1];
		while(n!=1) {
			if(bae[n]!=0) {
				bae[n-1] += bae[n];
				bae[n-2] += bae[n];
				n--;
			}
			else {
				bae[n-1]++;
				bae[n-2]++;
				n--;
			}
		}
		o = bae[1];
		z = bae[0];
//	    if (n == 0) {
//	    	z++;
//	    	return;
//	    } else if (n == 1) {
//	    	o++;
//	    	return;
//	    } else {
//	        fibo(n-1);
//	        fibo(n-2);
//	    }
	}	
	
}
