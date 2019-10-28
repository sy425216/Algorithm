package Baekjoon.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kth2_7469 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m,i, j,k, length;
        int[] arr, temp;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int index=0; index<n; index++)
            arr[index] = Integer.parseInt(st.nextToken());

        for(int index=0; index<m; index++){
            length=0;

            st = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st.nextToken())-1;
            j = Integer.parseInt(st.nextToken())-1;
            k = Integer.parseInt(st.nextToken())-1;
            for(int v=i; v<=j; v++) {    // 임시배열에 복사한다음 보내버리기
                temp[length++] = arr[v];
            }
            System.out.println(findKth(temp, 0, length-1, k));
        }


    }
    static int findKth(int[] temp, int start, int end, int kth){     // quicksort partition 써먹기 // 범위내에서 몇번쨰인지
        int pivot = temp[end], index=start;

        for(int i=start; i<end; i++)
            if(temp[i]<pivot)
                swap(temp, i, index++);     // 인덱스는 피봇의 n번째 수
        swap(temp, index, end);

        if(index<kth)   return findKth(temp, index+1, end, kth);    //k번째인데 시작이 index+1이니 수정해줘야함
        else if(index>kth) return findKth(temp, start, index-1, kth);
        else if(index==kth) return temp[index];

        return -111;
    }
    static void swap(int[] temp, int i, int j){
        int intTemp = temp[i];
        temp[i] = temp[j];
        temp[j] = intTemp;
    }
}
