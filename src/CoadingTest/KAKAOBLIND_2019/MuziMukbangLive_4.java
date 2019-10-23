// 완료

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

        int answer = -10, length = food_times.length, minus, index = 0, len = length, answer2 = 0;
        int[] sortArr = Arrays.copyOf(food_times, length);
        long k2 = k;

        Arrays.sort(sortArr);
        minus = 0;

        k++;


        while (k >= (long) len * (long) sortArr[index]) {
            //System.out.println(index);
            //System.out.println(minus);
            if (minus == 0)
                minus = sortArr[0];
            else
                minus += sortArr[index];


            if (sortArr[index] == 0 && index < length - 1) {
                if (index < length - 1) {
                    sortArr[index + 1] -= minus;
                    //minus += sortArr[index+1];
                }
                index++;
                len--;
                continue;
            }
            if (index < length - 1)
                sortArr[index + 1] -= minus;


            //System.out.println(k +"   " +minus);
            k -= (long) len * (long) sortArr[index];

            //System.out.println(k + "  " + index + "   "  + (length-1));

            if (k == 0 && (index == length - 1))
                for (int i = length - 1; i >= 0; i--)
                    if (food_times[i] == minus)
                        return i + 1;
            if (k != 0 && index == length - 1)
                return -1;

            len--;

            //minus += sortArr[index+1];
            index++;

        }
        while (k >= len)
            k -= len;

        System.out.println();


        index = 0;

        if (k == 0)
            for (int i = length - 1; i >= 0; i--) {
                if (food_times[i] > minus) {
                    return i + 1;
                }
            }


        while (k != 0 && index < length) {
            //System.out.println(k + "   " + minus);
            if (food_times[index] > minus)
                k--;
            index++;
        }

        answer = index;
        return answer;
    }

}

