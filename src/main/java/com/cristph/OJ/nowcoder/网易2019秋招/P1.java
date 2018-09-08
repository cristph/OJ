package com.cristph.OJ.nowcoder.网易2019秋招;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] count = new int[n];
        int[] sign = new int[n];
        int score = 0;
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            count[tmp - 1]++;
            sign[tmp - 1] = 1;
            score += check(sign, count, n);
        }
        sc.close();
        System.out.println(score);
    }

    private static int check(int[] sign, int[] count, int n) {
        for (int i = 0; i < n; i++) {
            if (sign[i] == 0) {
                return 0;
            }
        }
        for (int i = 0; i < n; i++) {
            count[i]--;
            if (count[i] == 0) sign[i] = 0;
        }
        return 1;
    }
}
