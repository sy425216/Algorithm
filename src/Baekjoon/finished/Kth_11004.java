package Baekjoon.finished;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kth_11004 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num, K, index=0;
		int [] bae, temp;
		String str;
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		num = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bae = new int[num];
		temp = new int[num];
		
		str = br.readLine();
		
		st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens())
			bae[index++] = Integer.parseInt(st.nextToken());
		
		mergeSort(bae, temp);
		
		System.out.println(bae[K-1]);
		
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
