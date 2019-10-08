package Baekjoon.finished;

import java.util.Scanner;

public class Tutle_2959 {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		int max=0, x1, x2, x3, y1, y2, y3;
		int [] arr = new int[4];
		int [] length = new int[3];
		
		for(int i=0; i<4; i++)
			arr[i] = input.nextInt();
		
		x1 = arr[0]<arr[1] ? arr[0] : arr[1];
		y1 = arr[2]<arr[3] ? arr[2] : arr[3];
		
		x2 = arr[0]<arr[2] ? arr[0] : arr[2];
		y2 = arr[1]<arr[3] ? arr[1] : arr[3];
		
		x3 = arr[0]<arr[3] ? arr[0] : arr[3];
		y3 = arr[1]<arr[2] ? arr[1] : arr[2];
	
		max = max>x1*y1 ? max : x1*y1;
		max = max>x2*y2 ? max : x2*y2;
		max = max>x3*y3 ? max : x3*y3;
		
		System.out.println(max);
	
	}
}
