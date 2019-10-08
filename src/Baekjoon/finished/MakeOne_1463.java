package Baekjoon.finished;

import java.util.Scanner;

public class MakeOne_1463 {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		int X, count=0, min;
		int[] arr = new int[1000001];
		
		X = input.nextInt();

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		if(X>3)
			for(int i=4; i<X+1; i++) {
				min=100000;
				
				if(i%3==0)
					min = arr[i/3]+1;
				if(i%2==0)
					min = (min<arr[i/2]+1) ? min : arr[i/2]+1;
				
				min = (min<arr[i-1]+1) ? min : arr[i-1]+1;
				
				arr[i] = min;
			}
		
		System.out.println(arr[X]);
		
	}

	
}
/*
if(X>3 && arr[X]==0) {
	
if(X%3==0) {
	toOne(arr, X/3);
	if(arr[X]>arr[X/3]+1 || arr[X]==0)
		arr[X] = arr[X/3]+1;
}

if(X%2==0) {
	toOne(arr, X/2);
	if(arr[X]>arr[X/2]+1 || arr[X]==0)
		arr[X] = arr[X/2]+1;
}

toOne(arr, X-1);
if(arr[X]>arr[X-1]+1 || arr[X]==0)
	arr[X] = arr[X-1]+1;
} 









for(int i=4; i<X+1; i++) {
	if(i%3==0)
		arr[i] = arr[i/3]+1;
	else if(i%2==0)
		arr[i] = arr[i/2]+1;
	else
		arr[i] = arr[i-1]+1;
			}
*/