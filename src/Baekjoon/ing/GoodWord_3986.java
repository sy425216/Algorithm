package Baekjoon.ing;

import java.util.Stack;
import java.util.Scanner;

public class GoodWord_3986 {
	
	public static void main(String args[]) {
		
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		
		Scanner input = new Scanner(System.in);
		int N, length, state, goodWord=0;
		String word;
		
		N = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<N; i++) {
			
			word = input.nextLine();
			length = word.length();
			
			for(int j=0; j<length; j++)
				stack1.add(word.charAt(j));
			
			if(stack1.size()%2 != 0)
				continue;
			
			while(stack1.isEmpty()!=true) {
				if(stack2.isEmpty()==true)
					stack2.push(stack1.pop());
				if(stack1.peek()==stack2.peek()) {
					stack1.pop();
					stack2.pop();
				}else {
					stack2.push(stack1.pop());
				}
			}
			
			if(stack2.empty()==true)
				goodWord++;
			
			stack1.clear();
			stack2.clear();
		}
		
		System.out.println(goodWord);
		
	}
	
}
