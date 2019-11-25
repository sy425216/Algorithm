package Baekjoon.finished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicSquare_1307 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, a, b, element=0, controlNum=0;

        N = Integer.parseInt(br.readLine());

        int[][] square1 = new int[N+1][N+1];
        int[][] square2 = new int[N+1][N+1];

        if(N%2==1) {      // 홀수마방진
            makeOddNumber(square1, N);
        }

        else if(N%4==0) { // 4의배수 마방진

            controlNum = N/4;

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    square2[i][j] = N*N-element++;        // square2 역순으로
                    square1[i][j] = element;              // square1 정순으로 채우기
                }
            }

            for(int i=1; i<=N; i++){
                if(i<=controlNum || i>(N-controlNum))
                    for(int j=controlNum+1; j<=N-controlNum; j++)
                        square1[i][j] = square2[i][j];
                else {
                    for (int j = 1; j <= controlNum; j++)
                        square1[i][j] = square2[i][j];
                    for (int j = (N - controlNum + 1); j <= N; j++)
                        square1[i][j] = square2[i][j];
                }
            }
        }

        else { // 4의배수가 아닌 짝수 마방진
            int semi = N/2;     // N/2 마방진 4개를 이용
            int[][] semiSquare = new int[semi+1][semi+1];

            makeOddNumber(semiSquare, semi);

            controlNum = N/4;

            for(int i=1; i<=semi; i++) {// 첫 작은 마방진
                if(i==controlNum+1)  // 첫작은마방진 가운데 줄이면
                    for (int j=2; j<=controlNum+1; j++)
                        square1[i][j] = 3;
                else
                    for(int j=1; j<controlNum+1; j++)
                        square1[i][j] = 3;
            }
            for(int i=1; i<=semi; i++) {// 둘 작은 마방진
                for(int j=semi+1; j<N-(controlNum-2); j++)
                    square1[i][j] = 2;
                for(int j=N-(controlNum-2); j<=N; j++)
                    square1[i][j] = 1;
            }

            for(int i=semi+1; i<=N; i++) {//셋넷 작은 마방진은 첫둘꺼 숫자바꾸기
                for (int j = 1; j <= semi; j++)
                    square1[i][j] = (square1[i-semi][j]==0) ? 3 : 0;
                for(int j=semi+1; j<=N; j++)
                    square1[i][j] = (square1[i-semi][j]==1) ? 2 : 1;
            }


            controlNum = N*N/4;   // 곱해주는용도 (14일땐 49)

            for(int i=1; i<=semi; i++){
                for(int j=1; j<=semi; j++){
                    square1[i][j] = square1[i][j]*controlNum+semiSquare[i][j];
                    square1[i+semi][j] = square1[i+semi][j]*controlNum+semiSquare[i][j];
                    square1[i][j+semi] = square1[i][j+semi]*controlNum+semiSquare[i][j];
                    square1[i+semi][j+semi] = square1[i+semi][j+semi]*controlNum+semiSquare[i][j];
                }
            }

        }

        for(int i=1; i<=N; i++) {
            for (int j = 1; j<=N; j++)
                System.out.print(square1[i][j]+" ");
            System.out.println();
        }

    }



    static void makeOddNumber(int[][] square1, int N){
        int a=1;    // y
        int b=N/2+1;  // x
        square1[a][b]=1;

        for(int i=2; i<=N*N; i++){
            a--; if(a<1) a+=N;
            b++; if(b==N+1) b-=N;

            if(square1[a][b]!=0){
                a+=2;   if(a>=N+1) a-=N;
                b--; if(b<1) b+=N;

                square1[a][b] = i;
            }
            else
                square1[a][b] = i;
        }
    }
}
