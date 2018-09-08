package com.cristph.OJ.nowcoder.网易2019秋招;

import java.util.ArrayList;
        import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>(n);
        int score = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp == 1) {
                score += s[i];
            } else {
                list.add(i);
            }
            t[i] = tmp;
        }

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int pos = list.get(i);
            int tmp = 0;
            for (int j = pos; (j < pos + k) && j < n; j++) {
                if (t[j] == 0) {
                    tmp += s[j];
                }
            }
            max = Math.max(max, tmp);
        }
        score += max;
        System.out.println(score);
    }
}
