package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BReader_15552 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Integer sum;
		int N;
		String[] sstr;
		
		N = Integer.parseInt(br.readLine());
		System.out.println(N);
		
		for(int i=0; i<N; i++) {
			sstr = br.readLine().split(" ");
			sum = Integer.parseInt(sstr[0])+Integer.parseInt(sstr[1]);

			bw.write(sum.toString());
			bw.newLine();
						
		}
		bw.flush();
		System.out.println("zzasdf");
	}

}
