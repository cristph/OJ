package com.cristph.OJ.nowcoder.美团点评2017年秋招;

import java.util.Scanner;

public class P4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        int[][] dp = new int[line1.length() + 1][line2.length() + 1];
        int max = 0;
        for (int i = 1; i <= line1.length(); i++) {
            for (int j = 1; j <= line2.length(); j++) {
                if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }
}
