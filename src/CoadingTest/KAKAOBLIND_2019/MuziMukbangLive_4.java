// �Ϸ�

package CoadingTest.KAKAOBLIND_2019;

import java.util.ArrayList;
import java.util.Arrays;

public class MuziMukbangLive_4 {

	public static void main(String[] args) {
		int[] food_times = {8, 8, 8, 8, 8, 8, 8};
		long k = 55;
		
		System.out.println(solution(food_times, k));
		

	}
	
	static int solution(int[] food_times, long k) {
		
		int answer=-10, length = food_times.length, minus, index=0, len = length, answer2=0;
		int[] sortArr = Arrays.copyOf(food_times, length);
		long k2 = k;
		
		Arrays.sort(sortArr);
		minus = 0;
		
		k++;				//  k��° �� ������ ����ؾߵǴϱ� �׳� k+1�� ����
		
		
		while(k>=(long)len*(long)sortArr[index]) {			// �ڷ����� ���� !!!!!!!!!
			//System.out.println(index);
			//System.out.println(minus);
			if(minus==0)
				minus = sortArr[0];			// �̷��� ������� �ѹ��� �ȵ������� minus�� �̻��Ѱ� �ȵ�
			else
				minus += sortArr[index];

			
			if(sortArr[index]==0 && index<length-1) {	// ��Ÿ�� ������ ���.. ���� ...!!!!!!!!
				if(index<length-1) {	// index�� �������� �ƴѰ�쿡/
					sortArr[index+1] -= minus;	// ���������� ���ݰ� ����
					//minus += sortArr[index+1];
				}
				index++;
				len--;
				continue;
			}
			if(index<length-1)	// index�� �������� �ƴѰ�쿡
				sortArr[index+1] -= minus;	// �������ҿ��� ���ݿ����� ������(minus) ���� �׸�ŭ (�ּڰ�*����)
			
			
			//System.out.println(k +"   " +minus);
			k -= (long)len*(long)sortArr[index];		// �ּڰ�*���� ��ŭ k���� ����   // �ڷ����� ���� !!!!!!!!!
			
			//System.out.println(k + "  " + index + "   "  + (length-1));
			
			if(k==0 && (index==length-1))		// �̰�쿡 �ߺ����� ���� ��� ������ұ� ex) k=8, [3, 3, 3] �ΰ��---> ������ ����������
				for(int i=length-1; i>=0; i--)
					if(food_times[i]==minus)
						return i+1;
			if(k!=0 && index==length-1)				// ���� ������ ���Ҵ�? �׷� �׳� ������// �ֳĸ� ���� �ٻ��µ� ���Ҵٴ� �Ҹ��ϰ�  = ���� ������ ����
				return -1;
			
			len--;		// ���� �ϳ� �ٽ����ϱ� �����ϳ� ���̱�
			
			//minus += sortArr[index+1];		// �̷��� minus�� ���ĵ� ���Ұ� ���ʴ�� ���� ��  (���� if������ �̸� ������)
			index++;
			
		}		// �� �ݺ����� ������ ���� k�� �ʹ�ũ�ų�   or  k�� 0���� len*sortArr[index]�̸��ϰ����
		while(k>=len) 						// 
			k-=len;		// length�� ���̰ų� ���� �ʿ䰡 ���� // �ֳĸ� ��� ���Ұ� �����ϱ� ����
		
		

		
		// ������� �ϸ� k�� ���� ������ ���� ����(!=������ ��) ���� ������ == �׳� �տ��� ���ͼ��� k��° �� return �ϸ� ��
		index=0;
	
		if(k==0)			// ���� ������ �ִµ� k�� 0�̵ƴ�? --> �����ִ� ���߿� ������ ���    // ���⼭ �������� --->> k=63 [8, 8, 8, 8, 100, 8, 8, 8]  �϶� ������8���;� �ϴµ�  minus�� 8����ƹ����� ���̾���
			for(int i=length-1; i>=0; i--) {
				if(food_times[i]>minus) {
					return i+1;
				}
			}
			
		
		while(k!=0 && index<length) {
			//System.out.println(k + "   " + minus);
			if(food_times[index]>minus)		// minus = ����� ���ҳ� �װ��� .. element�� minus���ٴ� Ŀ���� �Ѱ��� �����ִ°�
				k--;
			index++;
		}

		answer = index;
		return answer;
    }

}


/*
int answer=-10, index=0, length = food_times.length, minus=0, zero=0;
        int [] sortArr = new int[length];
        
        
        for(int n : food_times)
        	sortArr[index++] = n;
        Arrays.sort(sortArr);				// ������������ ���ĵ� �迭
        
        
        index=0;							// 0���� �ʱ�ȭ�ߴ�.
        while(k>length) {					// �ִ��� �ѹ��� ������ �̷��°�
        	if(k>length*sortArr[index]) {
        		k-=length*sortArr[index];
        		minus += sortArr[index];
        		sortArr[index+1] -= minus;	// ������������ �ߺ����� ������ -�� �ȵɶ��� ���ؼ� ������ ���� �� // ���߿� �꺸�� ������ 0�̶�� �����ϴ� �뵵�� ����� �� ������ !!!
        		sortArr[index]=0;			// sortArr�� food_times�� ������ �ʿ���// �����ϴµ� �׷��� ��-��
        		index++;
        		length--;
        		//System.out.println(length + "   " + k);
        	}
        	else if(k == length*sortArr[index]) {
        		for(int i=0 ; ;i++) {
        			//System.out.println(i);
        			if(food_times[i]!=0)
        				return i;
        		}
        	}
        	else {							// ��� Arr��*length�� k���� ������  --> �׷��� k�� length���ٴ� Ŭ��
        		k-=length;
        		//minus++;			// �긦 ������ұ�? 
        	}
        	
        	if(length<=1) {
        		//System.out.println("��");
        		if(k>=length)
        			return -1;
        		break;
        	}
        }
        
        index=0;
        
        length=food_times.length;
        while(k!=0) {
        	System.out.println("k       index       zero      minus");
        	System.out.println(k + "           "+ index + "            " + zero +"          "+ minus + "    " + food_times[index]);
        	if(food_times[index]>minus) {
        		k--;
        		
        		food_times[index]--;
        		index++;
        		
        		if(index==length)
        			index=0;
        	}
        	else {
        		zero++;
        		index++;
        	}
        	if(zero == length)
        		return -1;
        
        }
        
        
        answer = index+1;
        
        return answer;
 */