package Baekjoon.ing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GCDSum_9613 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t, n, sum, index, index1, index2, garbage;
		int[][] arr;
		String str;
		
		t = Integer.parseInt(br.readLine());
		arr = new int[t][100];
		
		
		for(int i=0; i<t; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			index=0;
			
			while(st.hasMoreTokens()) {
				if(index!=0)
					arr[i][index++] = Integer.parseInt(st.nextToken());
				if(index==0) {
					garbage = Integer.parseInt(st.nextToken());
					index++;
				}
			}
			
		}
		
		
		for(int i=0; i<t; i++) {
			index1=0;
			sum=0;
			while(arr[i][index1+1] != 0 && index1<99) {
				index2=index1+1;
				while(arr[i][index2]!=0 && index2<100) {
					//System.out.print(GCD(arr[i][index1], arr[i][index2]) + " ");
					sum += GCD(arr[i][index1], arr[i][index2]);
					index2++;
				}
				index1++;
				//System.out.println();
			}
			System.out.println(sum);
		}
		
		
	}
	
	static int GCD(int n1, int n2) {
		
		int gcd=0, until;
		
		if(n1>n2) {
			if(n1/2 > n2)
				until = n2;
			else 
				until = n1/2;
		}
		else {
			if(n2/2> n1)
				until = n1;
			else
				until = n2/2;
		}
		
		for(int i=1; i<=until; i++) {
			if(n1%i==0 && n2%i==0)
				gcd = i;
		}
		
		return gcd;
	}

}
