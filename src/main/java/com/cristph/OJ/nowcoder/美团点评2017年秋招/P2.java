package com.cristph.OJ.nowcoder.美团点评2017年秋招;

import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();
        int[] count = new int[k + 1];
        count[0] = 1;
        for (int i = 1; i <= k; i++) {
            int tmp = 0;
            if (i >= 100) tmp += count[i - 100];
            if (i >= 50) tmp += count[i - 50];
            if (i >= 20) tmp += count[i - 20];
            if (i >= 10) tmp += count[i - 10];
            if (i >= 5) tmp += count[i - 5];
            if (i >= 1) tmp += count[i - 1];
            count[i] = tmp;
        }
        System.out.println(count[k]);
    }
}
