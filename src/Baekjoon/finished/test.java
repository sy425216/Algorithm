package Baekjoon.finished;

import java.util.Scanner;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		int N, num, cnt=0, max=1, essential;
		int [][] arr;
		int [] count = new int[1000001];
		
		N = input.nextInt();
		input.nextLine();
		
		arr = new int[N][1000001];
		
		for(int i=0; i<N; i++) {
			
			num = input.nextInt();
			
			for(int j=2; j<=num; j++) {
				if(num%j==0) {
					count[j]++;					// �� ���� �˱����� ����
					arr[i][j]++;				// ���μ����� // arr[�ǹ̾��� �����ӱ׳�][num����� �Ҽ�]
					num /= j;
					j = 1;
				}
			}
		}
		

		for(int i=2; i<1000001; i++) {
			if(count[i]>=N) {					// �Ҽ��� N������ ������ �������� // �ű�� �̷��� �������ʿ���� �׳� ������ ä��� ��
				
				essential = count[i]/N;			
				
				for(int j=0; j<essential; j++)	// essential��ŭ ������ �ִ°Ŵ� �׸�ŭ �����������// ���ϸ� �ȴ� ����
					max *= i;
				
				
				for(int j=0; j<N; j++) {
					if(arr[j][i]<essential)		// ���� �����մ� �Ҽ��� ������ ��պ��� ������ �����ؾ���
						while(arr[j][i]!=essential) {
							cnt++;				// �ű涧���� �̵�Ƚ�� �߰�
							arr[j][i]++;
						}
				}
			}
		}
		
		
		System.out.println(max + " " + cnt);
		
		
	}

}

