package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactor_11653 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=2; i<N; i++) {
			if(N%i == 0) {
				System.out.println(i);
				N /= i;
				i = 1;
			}
		}
		if(N>1)
			System.out.println(N);
	}

}
