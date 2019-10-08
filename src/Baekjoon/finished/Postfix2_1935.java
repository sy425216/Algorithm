package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix2_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack<Double> stack = new Stack<Double>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, length, index=0;
		double pre, after;
		int [] alphabet = new int[26];
		String str;
		
		N = Integer.parseInt(br.readLine());
		
		str = br.readLine();
		length = str.length();
		
		for(int i=0; i<N; i++) 
			alphabet[i] = Integer.parseInt(br.readLine());
		
											// ���ǽ��� �ȸ��� ��� return 
		
		for(int i=0; i<length; i++) {
			if(str.charAt(i)=='+') {
				after = stack.pop();
				pre = stack.pop();
				stack.push(pre+after);
			}
			else if(str.charAt(i)=='-') {
				after = stack.pop();
				pre = stack.pop();
				stack.push(pre-after);
			}
			else if(str.charAt(i)=='*') {
				after = stack.pop();
				pre = stack.pop();
				stack.push(pre*after);
			}
			else if(str.charAt(i)=='/') {
				after = stack.pop();
				pre = stack.pop();
				stack.push(pre/after);
			}
			else {
				stack.push((double) (alphabet[(int)str.charAt(i)-65]));		// A=65   // ���ÿ��� �迭�� �ִ°��� ����(������ ����Ǵ� ��)
				
			}
		}
		
		System.out.printf("%.2f", stack.pop());
		

	}

}
