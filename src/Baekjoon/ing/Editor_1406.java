package Baekjoon.ing;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Editor_1406 {

	public static void main(String[] args) throws IOException {			
		
		LinkedList<Character> list = new LinkedList<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		String [] command = new String[2];
		int N=0, locate, length;
		
		str = br.readLine();
		length = str.length();

		N = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<length; i++)
			list.add(str.charAt(i));
		
		locate = list.size();
		
		
		
		for(int i=0; i<N; i++) {
			
			command = br.readLine().split(" ");
			
			if(command[0].charAt(0) == 'L') {
				if(locate == 0)
					continue;
				locate--;
			}
			else if(command[0].charAt(0) == 'D') {
				if(locate == list.size())
					continue;
				locate++;
			}
			else if(command[0].charAt(0) == 'B') {
				if(locate == 0)
					continue;
				locate--;
				list.remove(locate);
			}
			else if(command[0].charAt(0) == 'P') {
				if(locate == 0) {
					list.add(locate, command[1].charAt(0));
					continue;
				}
				list.add(locate++, command[1].charAt(0));
			}
			
		}
		
		for(int i = 0; i<list.size(); i++) 
			System.out.print(list.get(i));
		
		

	}

}