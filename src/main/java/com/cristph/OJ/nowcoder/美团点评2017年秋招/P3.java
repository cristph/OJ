package com.cristph.OJ.nowcoder.美团点评2017年秋招;

import java.util.Scanner;

public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int[] p = new int[k];
        for (int i = 0; i < k; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();
        int max = 0;
        for (int i = 0; i < k; i++) {
            int l = i, r = i;
            while (l - 1 >= 0 && p[l - 1] >= p[i]) {
                l--;
            }
            while (r + 1 < k && p[r + 1] >= p[i]) {
                r++;
            }
            max = Math.max(max, (r - l + 1) * p[i]);
        }
        System.out.println(max);
    }

}
