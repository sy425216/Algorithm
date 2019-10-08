/*
�ڵ��׽�Ʈ ���� 1�� 
���ڿ� ����

2���� ����

�׽�Ʈ���̽� �Ϸ�
*/
package Baekjoon.School;

public class CompressString {

	public static void main(String[] args) {
		String p = "abbbc";

		System.out.println(solution(p));

	}
/*
�� ����ȿ� �����������̷� �����Ѱ��� �������� ����
--> ������ �� ���̷θ� ���� ---> �߰��߰� �پ�Ѿ� ���൵ �Ұ���
���δ� ���ص� 200������ �ȵ���
*/
	static int solution(String p) {
		int result=p.length(); 
		int length = p.length(), index=0, count, middle=p.length()/2, min;
		boolean status = false;				// false�� �ٲ��� ó���ΰ�(n*���� �����̴ϱ� count-1)
		String compare;
	
		for(int i=1; i<=middle; i++) {	// 1������ ���ݰ� ���� ������
			compare = p.substring(0, i);
			min = p.length();
			count=0;
			status = false;
			//System.out.println("----------------------------");
			if(compare.equals("")==false) {
				for(int j=i; j+i<=length; j+=i) {		// i�� ������ ��
					//System.out.println(p.substring(j, j+i)+"    "+compare +"   "+j+"    "+(j+i));
					if(p.substring(j,j+i).equals(compare)) {
						//System.out.println();
						count+=i;					// ������̸�ŭ count���� (count�� ���߿� length���� ������)
						if(status == false) {		// ���� �ٲ�� ó����ġ�°� ���ڶ����� -1�����ֱ�
							status = true;
							count--;
						}
						//System.out.println("++++++++" + count + "++++++++++");
					}
					else {				// �ٸ� ���ڰ� ������ ��� ���� ����ġ��� status false��
						compare=p.substring(j, j+i);
						status = false;
					}
				}
			}
			
			min -= count;
			result = result < min ? result : min;
			
		}
		
		
		return result;
	}

}
