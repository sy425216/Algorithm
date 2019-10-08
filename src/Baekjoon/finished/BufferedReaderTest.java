package Baekjoon.finished;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		
		str = br.readLine();
		
		System.out.println(str);
		
		str = br.readLine();
		System.out.println(str);
		
		str = br.readLine();
		System.out.println(str);
		str = br.readLine();
		System.out.println(str);

	}

}
