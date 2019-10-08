package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class sort2_2751 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num;
		int [] bae, temp;
		String tmp;
		
		
		num = Integer.parseInt(br.readLine());
	
		bae = new int[num];
		temp = new int[num];
		
		
		for(int i=0; i<num; i++)
			bae[i] = Integer.parseInt(br.readLine());

		
		
		mergeSort(bae, temp);
		
		for(int i=0; i<num; i++)
			sb.append(bae[i]+"\n");
		
		System.out.println(sb);
		
	}
	
	static void mergeSort(int[] bae, int[] temp) {
		mergeSort(bae, 0, bae.length-1, temp);
	}
	static void mergeSort(int[] bae, int start, int end, int[] temp) {					// ����
		if(start>=end)
			return;
		
		int mid = (start+end)/2;
		mergeSort(bae, start, mid, temp);
		mergeSort(bae, mid+1, end, temp);
		
		merge(bae, start, mid, end, temp);
	}

	static void merge(int[] bae, int start, int mid, int end, int[] temp) {				// ����, ����
		int i=start, j=mid+1, idx=start;
		
		while(idx <= end) {
			if(i>mid) {
				temp[idx] = bae[j];
				idx++;
				j++;
			}
			else if(j>end) {
				temp[idx] = bae[i];
				idx++;
				i++;
			}
			else if(bae[i] > bae[j]) {
				temp[idx] = bae[j];
				idx++;
				j++;
			}
			else {
				temp[idx] = bae[i];
				idx++;
				i++;
			}
		}
		
		for(idx=start; idx<=end; idx++) 
			bae[idx] = temp[idx];		
		
	}
	

}