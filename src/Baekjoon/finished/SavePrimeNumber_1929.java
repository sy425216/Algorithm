package Baekjoon.finished;

import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;

public class SavePrimeNumber_1929 {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		StringBuilder sbd = new StringBuilder();
		
		int M, N, range, count = 0;
		int [] arr = new int[1000001];
		
		range = (int)Math.sqrt(1000000);
		
		
		M = input.nextInt();
		N = input.nextInt();
		
		arr[1]=1;
		
		for(int i=2; i<=range; i++) {
			if(arr[i]==1)
				continue;
			for(int j=i+i; j<=1000000; j+=i) {
				arr[j] = 1;
			}
		}
		
		
		for(int i=M; i<=N; i++)
			if(arr[i]==0) {
//				sbd.append(i);
//				sbd.append("\n");
				System.out.println(i);
				count++;
			}
//		System.out.println(sbd);
		
		System.out.println(count);

	}

}
