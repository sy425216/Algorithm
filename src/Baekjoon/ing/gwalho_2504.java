package Baekjoon.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class gwalho_2504 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack();
		
		char [] gwalho = br.readLine().toCharArray();
		int length = gwalho.length, sum=0, tempSum=0;
		int status=0;		// 0�̸� �� // 
		int [] count = new int[2];	// 0=( , 1=[
		
		
		
		// �ùٸ��� Ȯ��
		for(int i=0; i<length; i++) {
			if(gwalho[i]==')' )
				if(stack.isEmpty()==false)
					if(stack.peek()=='(') 
						stack.pop();
					else{
						System.out.println("0");
						return;
					}
				else{
					System.out.println("0");
					return;
				}
			if(gwalho[i]==']' )
				if(stack.isEmpty()==false)
					if(stack.peek()=='[') 
						stack.pop();
					else{
						System.out.println("0");
						return;
					}
				else{
					System.out.println("0");
					return;
				}
			else if(gwalho[i]=='(' || gwalho[i]=='[')
				stack.push(gwalho[i]);
			else {
				System.out.println("0");
				return ;
			}
		}
		if(stack.isEmpty()==false) {
			System.out.println("0");
			return ;
		}
		// �������
		
		
		
		
		
		for(int i=0; i<length; i++)			// ���ÿ� �ֱ�
			stack.push(gwalho[i]);
		
		
		while(stack.isEmpty()==false) {
			
		}
		
		
	}
	
	
}
