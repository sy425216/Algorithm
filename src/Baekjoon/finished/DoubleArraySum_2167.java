package Baekjoon.finished;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DoubleArraySum_2167 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder outputResult = new StringBuilder();
		Scanner input = new Scanner(System.in);
		
		
		int N, M, count;
		int [] sum;
		int [][] arr;
		int [] point = new int[4];
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {						// NxM �迭�̴ϱ� N����ŭ ���پ� �Է¹ޱ�
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			
			int j=0;
			
			while(st.hasMoreTokens()) {					// �迭�� �� ä���
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		
		count = Integer.parseInt(br.readLine());
		sum = new int[count];
		
		
		for(int i=0; i<count; i++) {					// ���⼭ ��Ƽ������ ? 
			
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			
			for(int p=0; p<4; p++) {
				point[p] = Integer.parseInt(st.nextToken())-1;
			}
			
			for(int index = point[0]; index<=point[2]; index++)
				for(int index2=point[1]; index2<=point[3]; index2++)
					sum[i] += arr[index][index2];
			
		}
		
		
		for(int i=0; i<count; i++) {
			outputResult.append(sum[i]);
			outputResult.append("\n");
		}
		
		System.out.println(outputResult);
		
		
	}

}


