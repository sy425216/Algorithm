package Baekjoon.finished;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TasteWine_2156 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, max=0, ableMax=0;
		int [] wine;
		int [] maxWine;
		
		
		n = Integer.parseInt(br.readLine());
		wine= new int[n];
		maxWine = new int[n];
		
		for(int i=0; i<n; i++)
			wine[i] = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(wine[0]);
			return ;
		}
			
		maxWine[0] = wine[0];
		maxWine[1] = wine[0]+ wine[1];
		ableMax = wine[0]>wine[1] ? wine[0] : wine[1];
		
		for(int i=2; i<n; i++) {
			
			maxWine[i] = (wine[i]+ableMax > maxWine[i-1]) ? wine[i]+ableMax : maxWine[i-1];
			maxWine[i] = (maxWine[i]>wine[i]+maxWine[i-2]) ? maxWine[i] : wine[i]+maxWine[i-2];
			
			
			ableMax=wine[i]+maxWine[i-2];
			
			//System.out.println(maxWine[i]+"          "+ableMax);
		}
		
		System.out.println(maxWine[n-1]);
		
	}
	

}
