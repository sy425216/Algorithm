package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rank_2012{

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long sum=0;
		int [] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		quickSort(arr, 0, arr.length);
		
		for(int i=0; i<n; i++) {
			//System.out.print(arr[i]+"   ");
			sum += Math.abs((long)(i+1)-(long)arr[i]);
		}
		System.out.println(sum);
		
	}
	
	
	//QuickSort ����
	static void quickSort(int[] arr, int start, int end) {
		if(start<end) {
			int middle = partition(arr, start, end);
			quickSort(arr, start, middle);
			quickSort(arr, middle+1, end);
		}
	}
	static int partition(int[] arr, int start, int end) {
		swap(arr, (start+end)/2, end-1);
		int pivot=arr[end-1], index=start;
		
		for(int i=start; i<end-1; i++) 
			if(arr[i]<pivot) 
					swap(arr, index++, i);
		
		swap(arr, end-1, index);
		
		return index;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
