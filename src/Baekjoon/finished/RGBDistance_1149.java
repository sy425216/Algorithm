package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RGBDistance_1149 {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] rgb, minRoad;
		int N, index, min=1000001, tempMin;					// �ּڰ� 1000�ƴϴ� �ؽž�
		String str;
		
		N = Integer.parseInt(br.readLine());
		
		rgb = new int[N][3];
		minRoad = new int[N][3];
		
		for(int i=0; i<N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			index = 0;
			
			while(st.hasMoreTokens())
				rgb[i][index++] = Integer.parseInt(st.nextToken());
			
		}
		
		
		minRoad[0][0] = rgb[0][0];
		minRoad[0][1] = rgb[0][1];
		minRoad[0][2] = rgb[0][2];
		
		for(int i=1; i<N; i++) {
			tempMin = (minRoad[i-1][1] < minRoad[i-1][2]) ? minRoad[i-1][1] : minRoad[i-1][2];
			minRoad[i][0] = rgb[i][0] + tempMin;
			
			tempMin = (minRoad[i-1][0] < minRoad[i-1][2]) ? minRoad[i-1][0] : minRoad[i-1][2];
			minRoad[i][1] = rgb[i][1] + tempMin;
			
			tempMin = (minRoad[i-1][0] < minRoad[i-1][1]) ? minRoad[i-1][0] : minRoad[i-1][1];
			minRoad[i][2] = rgb[i][2] + tempMin;
		
		}
		
		for(int i=0; i<3; i++)
			min = (min<minRoad[N-1][i]) ? min : minRoad[N-1][i];
		
		System.out.println(min);
		
	}

}
