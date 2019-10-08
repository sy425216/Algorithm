package Baekjoon.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Oasis_3015 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, count=0, sum=0, num;
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> forSum = new Stack<Integer>();
		
		
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			num = Integer.parseInt(br.readLine());
			
			if(stack.isEmpty()==true)					// ������ ��������� push
				stack.push(num);
			else if(stack.peek()<num) {					// ���� ���ú��� ũ��? ---> (�ǹ��� ������ ũ�� �װŻ��� �ٻ��� // ������Ŀ? �ٻ��׷�)
				
				while(stack.size()!=1) {
//					if(stack.pop()==stack.peek())
//						forSum.push(forSum.peek()+1);
//					else
					stack.pop();
						forSum.push(1);
				}
				if(stack.peek()<=num) {
					stack.pop();
					forSum.push(1);
				}
				
				stack.push(num);
			}
			else if(stack.peek()>num) {					// ������ ������ ũ�ݾ�? ---> �׳� ���� count++
				stack.push(num);
				forSum.push(1);
			}
			else if(stack.peek()==num) {
				stack.push(num);						// ���� �����Ұ� �̸� ���ش� ���� // �����ʿ�
				forSum.push(forSum.peek()+1);
			}
		}
		
		
		while(forSum.isEmpty()!=true)
			sum+=forSum.pop();
		
		System.out.println(sum);

	}

}