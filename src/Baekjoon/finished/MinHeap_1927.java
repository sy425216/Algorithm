package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinHeap_1927 {     // 인덱스 초과 개선하기

    static int length=0;    // 힙 길이

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] heap = new int[500000];
        int N, x;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            x = Integer.parseInt(br.readLine());


            if(x!=0){
                int index = length;
                heap[index]=x;

                while(index!=0){
                    if(heap[index] < heap[(index-1)/2]) {
                        swap(heap, index, (index-1)/2);
                        index = (index-1)/2;
                    }
                    else
                        break;
                }
                length++;
            }
            else if(length!=0){
                int index = 0;
                int temp=-1;

                sb.append(heap[0]+"\n");

                heap[0] = heap[--length];
                heap[length]=0;

                while(index<length){
                    if(heap[index*2+2]!=0){ // 자식이 둘다 잇으면 비교해서 바꾸기
                        temp = (heap[index*2+1]<heap[index*2+2]) ? index*2+1 : index*2+2;

                        //System.out.println(temp + "---" + heap[index] +"   "+heap[temp]);
                        if(heap[index]>heap[temp]){
                            swap(heap, index, temp);
                            //System.out.println(heap[index]+"--------");
                            index = temp;
                        }
                        else
                            break;

                    }
                    else if(heap[index*2+1]!=0) { // 자식 하나만 있으면 나랑 비교해서 바꾸기
                        if(heap[index]>heap[index*2+1]){
                            swap(heap, index, index*2+1);
                            index = index*2+1;
                        }
                        else
                            break;
                    }
                    else
                        break;
                }
            }
            else    // 힙이 비었을 경우
                sb.append(0+"\n");
        }


        System.out.println(sb);

    }


    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
