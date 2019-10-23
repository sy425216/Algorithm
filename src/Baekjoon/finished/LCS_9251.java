package Baekjoon.finished;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1, s2;
		s1 = br.readLine();
		s2 = br.readLine();
		
		int length1 = s1.length()+1, length2 = s2.length()+1;
		int plus=0, max=0;
		int [][] lcs = new int[length1][length2];
		
		
		for(int i=1; i<length1; i++) {
			plus=0;
			for(int j=1; j<length2; j++) {
				
				plus = (plus>lcs[i-1][j-1]) ? plus : lcs[i-1][j-1];
				
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					lcs[i][j] = plus+1;
				}
				else {
					lcs[i][j] = (lcs[i-1][j]>lcs[i][j-1]) ? lcs[i-1][j] : lcs[i][j-1];
				}

			}
		}
		
		for(int i=0; i<length1; i++) {
			for(int j=0; j<length2; j++) {
				max = (max>lcs[i][j]) ? max : lcs[i][j];
				//System.out.print(lcs[i][j]);
			}
			//System.out.println();
		
		}
		
		System.out.println(max);
		
	}

}
