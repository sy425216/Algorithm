package Baekjoon.finished;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort_1083 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, S, index=0, max=0, minus=0;
        int[] arr, sortArr;
        String str;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sortArr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }

        Arrays.sort(sortArr);
        S = Integer.parseInt(br.readLine());


        // 여기부터
        while(S>0) {
            if(isSort(arr))//완전히 정렬되면 나가기
                break;

            for (index = 0; index < N; index++) {

                for (int i = 0; i < N-minus; i++) {   // i번째로 큰 값을 index위치로 보내는 반복문 // 확정된 자리수만큼 덜 반복
                   for (int j = minus; j < N; j++) { // i번째로 큰값 위치찾기
                       //System.out.println("arr[j]="+arr[j] + "   sortArr[N-1-i]="+sortArr[N-1-i]);
                        if (arr[j] == sortArr[N-1-i]) {
                            max = j;
                            //System.out.println(max + "  "+minus);
                            break;
                        }
                    }
                    if (S-(max-minus) >= 0) { //바꿀수있나 보고 가능하면 바꾸기 // max위치값 0으로바꾸고 sort재정렬

                        S-=(max-minus);

                        if (max == minus){
                            sortArr[N-1-i]=0;
                            Arrays.sort(sortArr);
                            minus++;
                            break;
                        }
                        sortArr[N-1-i]=0;
                        Arrays.sort(sortArr);

                        for (; max > minus; max--)
                            swap(arr, max, max - 1);


                        minus++;    // 앞에자리부터 확정된위치는 제외하려고

                        //for(int ii=0; ii<N; ii++)
                            //System.out.print(sortArr[ii]+"   ");
                       //System.out.println();
                        //for(int ii=0; ii<N; ii++)
                            //System.out.print(arr[ii]+"   ");
                       // System.out.println();

                        break;
                    }
                }


                if(S<=0)
                    break;

            }
        }

        for(int i=0; i<N; i++)
            System.out.print(arr[i]+" ");

    }



    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static boolean isSort(int[] arr){
        int length = arr.length;

        for(int i=0; i<length-1; i++)
            if(arr[i]<arr[i+1])
                return false;

        return true;
    }
}
