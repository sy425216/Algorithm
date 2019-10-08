// �Ϸ�


package CoadingTest.KAKAOBLIND_2019;

public class FailureRate_2 {

	public static void main(String[] args) {
		
		int [] stages = {2,8,7,6,5,4,4,4,3,2,5,2,1};
		int N =7;
		
		int[] answer = solution(N, stages);
		
		for(int n : answer)
			System.out.println(n);

	}
	
	static int[] solution(int N, int[] stages) {
        
		int temp = 0;
		int length = stages.length;
		int amount = length;
		double max;
		int[] answer = new int[N];
        int[] count = new int[N+2];
        double [] rate = new double[N+2];
        
        
        for(int i=0; i<length; i++) 
        	count[stages[i]]++;
        
        for(int i=1; i<N+1; i++) {
        	if(length!=0) {						// �߿� !!!!
        		rate[i] = (double)count[i]/length;
        		length -= count[i];
        	}else {
        		rate[i] = 0;
        	}
        }
        	
        for(int i=0; i<N; i++) {
        	max = -1;
        	for(int j=1; j<N+1; j++) {			/// ????
        	//System.out.println(rate[j] + "     " + max);
        		if(rate[j]>max) {
        			temp = j;
        			max = rate[temp];
        		}
        	}
        	//System.out.println(temp + " " + rate[temp]);
        	answer[i] = temp;
        	rate[temp] = -1;
        }
        
        
        return answer;
    }

}
