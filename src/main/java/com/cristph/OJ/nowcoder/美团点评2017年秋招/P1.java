package com.cristph.OJ.nowcoder.美团点评2017年秋招;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();
        int[] count = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            int tmp = 1;
            for (int j = 1; j < i; j++) {
                tmp += count[j];
            }
            count[i] = tmp;
        }
        System.out.println(count[k]);
    }
}
