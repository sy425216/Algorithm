package Baekjoon.finished;

import java.util.LinkedList;
import java.util.Scanner;

public class Josepus_1158 {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Scanner input = new Scanner(System.in);
		
		int N, K, locate=0;
		

		N = input.nextInt();
		K = input.nextInt();
		
		for(int i=0; i<N; i++)
			list.add(i+1);
		
		
		System.out.print("<");
		
		
		locate = K-1;
		
		while(list.size()!=1) {
			System.out.print(list.get(locate) + ", ");
			list.remove(locate);
			
			locate += (K-1);
			if(locate >= list.size())
				locate %= list.size();
		}
		
		System.out.println(list.get(0) + ">");
		

	}

}
