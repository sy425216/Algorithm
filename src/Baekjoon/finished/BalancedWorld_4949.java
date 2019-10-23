package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld_4949 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		String str;
		char [] chArr;
		
		while((str=br.readLine()).equals(".")==false) {
			chArr = str.toCharArray();
			
			for(int i=0; i<chArr.length; i++) {
				if(chArr[i]=='(') {
					stack.push(chArr[i]);
				}
				else if(chArr[i]=='[') {				// "
					stack.push(chArr[i]);
				}
				else if( chArr[i]==']' || chArr[i]==')' ) {
					if(stack.isEmpty()==true) {
						stack.push(chArr[i]);
						break;
					}
					else if(chArr[i]==']' && stack.peek()=='[')
						stack.pop();
					else if(chArr[i]==')' && stack.peek()=='(')
						stack.pop();
					else {
						stack.push(chArr[i]);
						break;
					}
				}
				
			}
			
			if(stack.isEmpty()==true)
				System.out.println("yes");
			else {
				System.out.println("no");
				stack.clear();
			}
		}

	}

}
