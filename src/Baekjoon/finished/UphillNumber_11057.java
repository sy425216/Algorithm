package Baekjoon.finished;

/*

arr[0] = ����arr[0~9]��
arr[1] = ����arr[1~9]��
.
.
.
.
arr[9] = ����arr[9]

---> result N = arr��
*/
import java.util.Scanner;

public class UphillNumber_11057 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int [] uphillCount = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int N, result=0, sum;
		
		N = input.nextInt();
		
		for(int nn=2; nn<N; nn++) {
			for(int i=0; i<10; i++) {
				
				sum=0;
				for(int j=i; j<10; j++) {
					sum += (uphillCount[j]%10007);
				}
				uphillCount[i] = sum;
			}
		}
		
		if(N==1)
			result = 10;
		else
			for(int i=0; i<10; i++)
			result += uphillCount[i];
		
		
		System.out.println(result%10007);
	}
	
}
