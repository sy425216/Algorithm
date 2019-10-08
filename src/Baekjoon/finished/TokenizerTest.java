package Baekjoon.finished;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TokenizerTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		
		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());

	}

}
