package Baekjoon.finished;
//   A < B < C	// 65, 66, 67

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ABC_3047 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [] num = new int[3];
		int temp;
		
		String str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		for(int i=0; i<3; i++)
			num[i] = Integer.parseInt(st.nextToken());

		for(int i=0; i<2; i++)
			for(int j=0; j<2-i; j++) {
				if(num[j]>num[j+1]) {
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
			
		
		char [] abc = br.readLine().toCharArray();
		
		for(int i=0; i<3; i++) {
			switch(abc[i]) {
			case 'A' : System.out.print(num[0]);
				break;
			case 'B' : System.out.print(num[1]);
				break;
			case 'C' : System.out.print(num[2]);
				break;
			}
			System.out.print(" ");
		}
		
	}

}
