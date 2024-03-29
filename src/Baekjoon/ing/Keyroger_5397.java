package Baekjoon.ing;

import java.util.Scanner;
import java.util.LinkedList;

public class Keyroger_5397 {

	public static void main(String[] args) {
		
		LinkedList<Character> list = new LinkedList<Character>();
		LinkedList<Character> outputList = new LinkedList<Character>();
		Scanner input = new Scanner(System.in);
		
		int caseNum, pLength, size, locate;
		String password;
		char word;
		
		caseNum = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<caseNum; i++) {
			
			locate=0; 
			
			password = input.nextLine();
			pLength = password.length();
			
			for(int j=0; j<pLength; j++)
				list.add(j, password.charAt(j));
			
			size = list.size();
			
			for(int j=0; j<size; j++) {						
				
				if(list.get(j) == '<') {
					if(locate == 0)
						continue;
					locate--;
				}
				else if(list.get(j) == '>') {
					if(locate == outputList.size())
						continue;
					locate++;
				}
				else if(list.get(j) == '-') {
					if(locate == 0)
						continue;
					locate--;
					outputList.remove(locate);
				}
				else {
					outputList.add(locate, list.get(j));
					locate++;
				}
			}
			
			for(int j=0; j<outputList.size(); j++)
				System.out.print(outputList.get(j));
			System.out.println();
			
			outputList.clear();
			list.clear();
		}

	}

}
