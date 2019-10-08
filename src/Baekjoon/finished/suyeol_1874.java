package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class suyeol_1874 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		Stack<Integer> suyeol = new Stack<Integer>();
		
		
		int n, num=0, index=1;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++){
			
			num = Integer.parseInt(br.readLine());
			
			while(index<=num) {
				suyeol.push(index++);
				result.append("+\n");
			}
			
			
			if(suyeol.pop()!=num) {
				System.out.println("NO");
				return ;
			}
			
			result.append("-\n");
			
				
		}
		
		System.out.println(result);
		
		
	}

}
