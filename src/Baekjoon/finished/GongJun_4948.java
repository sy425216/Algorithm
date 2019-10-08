package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;

public class GongJun_4948 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N, count = 0, range;
		int [] arr = new int[246913];
		
		
		range = (int) Math.sqrt(246913);
		
		for(int i=2; i<=range; i++) {
			if(arr[i]==1)
				continue;
			for(int j=i+i; j<=246912; j+=i) {
				arr[j] = 1;
			}
		}
		
		
		while((N=Integer.parseInt(br.readLine()))!=0 ) {
			
			count=0;
		
			for(int i=N+1; i<=2*N; i++) {
				if(arr[i]==0)
					count++;
			}
			System.out.println(count);
		}
	}

}
