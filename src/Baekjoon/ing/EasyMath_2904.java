package Baekjoon.ing;


import java.util.Scanner;
import java.io.IOException;

public class EasyMath_2904 {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		int N, num, cnt=0, max=1, essential;
		int[][] arr ;
		int [] count = new int[1000001];
		int [] sosu = new int[1000001];
		
		N = input.nextInt();
		input.nextLine();
		
		arr = new int[100][78498];
		
		savePrimeNum(sosu);						// �Ҽ� �迭�� �Ҽ��� ���° �Ҽ����� �����ض� 
		
		for(int i=0; i<N; i++) {
			
			num = input.nextInt();
			
			for(int j=2; j<=num; j++) {
				if(num%j==0) {
					count[j]++;					// �� ���� �˱����� ����
					arr[i][sosu[j]]++;				// ���μ����� // arr[�ǹ̾��� �����ӱ׳�][num����� �Ҽ�]
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
	
	static void savePrimeNum(int [] arr ) {									// �Ҽ� ���ϴ� �Լ�
		int M, N, range, count = 0, th=0;
		
		range = (int)Math.sqrt(1000000);
		
		Scanner input = new Scanner(System.in);
		
		M = input.nextInt();
		N = input.nextInt();
		
		arr[1]=-1;
		
		for(int i=2; i<=range; i++) {
			if(arr[i]==-1)
				continue;
			for(int j=i+i; j<=1000000; j+=i) {
				arr[j] = -1;
			}
		}
		
		for(int i=2; i<1000001; i++) 										// �Ҽ��� ���°���� üũ�ϴ°��� ���� �ù�  �ֳİ�? ���������Ӹ�
			if(arr[i]==0) 
				arr[i] = th++;
		
	}
	

}

