package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class IntSemo_1932 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str;
		int[][] semo;
		int[][] maxSum;
		int n, tempMax=0, max=0;
		
		n = Integer.parseInt(br.readLine());
		
		semo = new int[n][n];
		maxSum = new int[n][n];
		
		for(int i=0; i<n; i++) {
			int index=0;
			
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			
			while(st.hasMoreTokens()) 
				semo[i][index++] = Integer.parseInt(st.nextToken());
			
		}
		
		maxSum[0][0] = semo[0][0];
		
		for(int i=1; i<n; i++) {			// ���پ� �������鼭
			for(int j=0; j<=i; j++) {		// �� ���� ?
				
				if(j==0) 					// ó���� ���
					maxSum[i][j] = maxSum[i-1][j] + semo[i][j];
				else if(j==i) 				// �������ϰ��
					maxSum[i][j] = maxSum[i-1][j-1] + semo[i][j];
				else {						// �߰������ΰ��
					maxSum[i][j] = (maxSum[i-1][j-1] > maxSum[i-1][j]) ? maxSum[i-1][j-1]+semo[i][j] : maxSum[i-1][j]+semo[i][j];
				}
			}
		}
		

		for(int i=0; i<n; i++)			// �ǹ��ٿ��� �ִ� ã��
			max = (max>maxSum[n-1][i]) ? max : maxSum[n-1][i];
		
		System.out.println(max);
	}

}
