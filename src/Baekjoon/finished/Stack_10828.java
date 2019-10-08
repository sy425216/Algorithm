package Baekjoon.finished;

import java.util.Scanner;

public class Stack_10828 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		Stack stack = new Stack();
		
		int N, commandNum;
		String command = null;
		String [] com = new String[2];
		
		N= input.nextInt();
		input.nextLine();
		
		
		for(int i=0; i<N; i++) {
			command = input.nextLine();
			com = command.split(" ");
			
			if(com[0].equals("push")) {
				commandNum = Integer.parseInt(com[1]);
				stack.push(commandNum);
			}
			else if(command.equals("pop")) {
				System.out.println(stack.pop());
			}
			else if(command.equals("size")) {
				System.out.println(stack.size());
			}
			else if(command.equals("empty")) {
				System.out.println(stack.empty());
			}
			else if(command.equals("top")) {
				System.out.println(stack.top());
			}
		}
		
		

	}

}

class Stack{
	
	private class Node{
		int num;
		Node link=null;
	}
	
	private Node now;
	
	
	
	public Stack() {
		now = new Node();
	}
	
	public void push(int num) {
		now.num = num;
		Node next = new Node();
		next.link = now;
		now = next;
	}
	public int pop() {
		int num2;
		
		if(now.link==null)
			return -1;
		now = now.link;
		num2 = now.num;
		now.num=0;
		return num2;
	}
	public int size() {
		Node temp = now;
		int count=0;
		
		while(temp.link != null) {
			temp = temp.link;
			count++;
		}
		return count;
	}
	public int empty() {
		if(now.link != null)
			return 0;
		else
			return 1;
	}
	public int top() {
		if(now.link != null)
			return now.link.num;
		else
			return -1;
	}
	
}