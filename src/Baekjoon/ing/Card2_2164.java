package Baekjoon.ing;

import java.util.Scanner;

public class Card2_2164 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int index=0;
        int[] arr = new int[2000000];
        int switchIndex=N;

        if(N==1){
            System.out.println(1);
            return;
        }

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        while(index<switchIndex){
            index++;
            if(index==switchIndex-1)
                break;
            swap(arr, index++, switchIndex++);
            if(index==switchIndex-1)
                break;
        }

        System.out.println(arr[index]);
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
