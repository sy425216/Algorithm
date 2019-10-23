package Baekjoon.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FrogPrincess_2983 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char [] direction;
		int N, K, x, y, myIndex=0;
		int[][] xy;
		int[][] xy2;
		int [] my = new int[2];
		String str;
		int minIndex=0;
		boolean status;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		xy = new int[N][2];
		xy2 = new int[N][2];
		direction = br.readLine().toCharArray();
				
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
	
		
		my[0] = xy[0][0];
		my[1] = xy[0][1];
		
		mergeSort(xy, xy2);
		
		
		
		for(int i=0; i<N; i++)
			if(my[0]==xy[i][0] && my[1]==xy[i][1]) {
				myIndex = i;
				break;
			}
		
		
		for(int i=0; i<K; i++) {
			switch(direction[i]) {
			case 'A' : 
				if(myIndex+1<N) {
					for(int j=myIndex+1; j<N; j++) {
						if(xy[j][0]!=-1) {
							if((xy[j][0]-my[0] == xy[j][1]-my[1]) && xy[j][0]-my[0]>0) {
								xy[myIndex][0]=-1;	xy[myIndex][1]=-1;
								my[0] = xy[j][0]; my[1] = xy[j][1];
								myIndex = j;
							}
						}
					}
				}
				//System.out.println(myIndex);
				break;
			case 'B' :
				if(myIndex+1<N) {
					for(int j=myIndex+1; j<N; j++) {
						if(xy[j][0]!=-1) {
							if((xy[j][0]-my[0] == (-1)*(xy[j][1]-my[1])) && (xy[j][1]-my[1])<0 ) {
								xy[myIndex][0]=-1;	xy[myIndex][1]=-1;
								my[0] = xy[j][0]; my[1] = xy[j][1];
								myIndex = j;
							}
						}
					}
				}
				//System.out.println(myIndex);
				break;
			case 'C' :
				if(myIndex-1>=0) {
					for(int j=myIndex-1; j>=0; j--) {
						if(xy[j][0]!=-1) {
							if((xy[j][0]-my[0] == (-1)*(xy[j][1]-my[1])) && (xy[j][0]-my[0])<0) {
								xy[myIndex][0]=-1;	xy[myIndex][1]=-1;
								my[0] = xy[j][0]; my[1] = xy[j][1];
								myIndex = j;
							}
						}
					}
				}
				//System.out.println(myIndex);
				break;
			case 'D' :
				if(myIndex-1>=0) {
					for(int j=myIndex-1; j>=0; j--) {
						if(xy[j][0]!=-1) {
							if((xy[j][0]-my[0] == xy[j][1]-my[1]) && xy[j][0]-my[0]<0) {
								xy[myIndex][0]=-1;	xy[myIndex][1]=-1;
								my[0] = xy[j][0]; my[1] = xy[j][1];
								myIndex = j;
							}
						}
					}
				}
				//System.out.println(myIndex);
				break;
			}
		}
		
		System.out.println(xy[myIndex][0] + " " + xy[myIndex][1]);
		
	
	}
	
	
	
	
	
	static void mergeSort(int[][] bae, int[][] temp) {
		mergeSort(bae, 0, bae.length-1, temp);
	}
	static void mergeSort(int[][] bae, int start, int end, int[][] temp) {					// ����
		if(start>=end)
			return;
		
		int mid = (start+end)/2;
		mergeSort(bae, start, mid, temp);
		mergeSort(bae, mid+1, end, temp);
		
		merge(bae, start, mid, end, temp);
	}

	static void merge(int[][] bae, int start, int mid, int end, int[][] temp) {
		int i=start, j=mid+1, idx=start;
		
		while(idx <= end) {
			if(i>mid) {
				temp[idx][0] = bae[j][0];
				temp[idx][1] = bae[j][1];
				idx++;
				j++;
			}
			else if(j>end) {
				temp[idx][0] = bae[i][0];
				temp[idx][1] = bae[i][1];
				idx++;
				i++;
			}
			else if(bae[i][0] > bae[j][0]) {
				temp[idx][0] = bae[j][0];
				temp[idx][1] = bae[j][1];
				idx++;
				j++;
			}
			else {
				temp[idx][0] = bae[i][0];
				temp[idx][1] = bae[i][1];
				idx++;
				i++;
			}
		}
		
		for(idx=start; idx<=end; idx++) {
			bae[idx][0] = temp[idx][0];
			bae[idx][1] = temp[idx][1];
		}
	}
		
}
