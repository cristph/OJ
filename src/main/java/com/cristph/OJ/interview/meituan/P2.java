package com.cristph.OJ.interview.meituan;

import java.util.HashMap;
import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();

        HashMap<Integer, Integer> map = new HashMap<>(k);
        int count = 0;
        for (int i = 0; i < n - k; i++) {
            for (int j = i; j < i + k; j++) {
                int tmp = map.getOrDefault(p[j], 0) + 1;
                if (tmp >= t) {
                    count++;
                    break;
                }
                map.put(p[j], tmp);
            }
            map.clear();
        }
        System.out.println(count);
    }
}
