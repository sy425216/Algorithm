package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SequenceSum_1912 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str;
		int[] arr;
		int n, max, index=0, tempMax;					// ���� max min ���� �ؽžƤФ�	
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens()) 
			arr[index++] = Integer.parseInt(st.nextToken());
		max = arr[0];									// ù��° ������ �ִ� ����
		
		
		for(int i=0; i<n-1; i++) {
			tempMax=arr[i];
			max = (max>tempMax) ? max : tempMax;		// ��� ���Ծ����� ���� ��
			
			for(int j=i+1; j<n; j++) {
				tempMax += arr[j];
				max = (max>tempMax) ? max : tempMax;
			}
		}
		
		max = (max>arr[n-1]) ? max : arr[n-1];			// ������ ���� �� ū���
		
		System.out.println(max);

	}

}
