package com.cristph.OJ.nowcoder.网易2019秋招;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        sc.close();
//        char[] array = str.toCharArray();
//        int b_count = 0;
//        int w_count = 0;
//        for (Character c : array) {
//            if (c == 'b') b_count++;
//            else w_count++;
//        }
//        if (Math.abs(b_count - w_count) <= 1) {
//            System.out.println(array.length);
//        } else {
//            System.out.println(Math.min(b_count, w_count) * 2 + 1);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            int k = sc.nextInt();
//            if (n <= 2) {
//                System.out.println("0 0");
//            } else {
//                int half = n / 2;
//                if (k <= half) {
//                    System.out.println("0 " + ((k - 1) >= 0 ? (k - 1) : 0));
//                } else {
//                    System.out.println("0 " + (n - k));
//                }
//            }
//        }
//        sc.close();
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // tou piao
        int n = sc.nextInt();
        // hou xuan
        int m = sc.nextInt();

        // 没人的票数
        int[] count = new int[m + 1];

        int maxp = 0;
        int p = 0;

        // 没人的票改变需要躺输
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>(m);
        for (int i = 1; i <= m; i++) {
            map.put(i, new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }));
        }

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            count[h]++;
            if (count[h] > maxp) {
                maxp = count[h];
                p = h;
            }
            PriorityQueue<Integer> queue = map.get(h);
            int v = sc.nextInt();
            queue.add(v);
        }
        sc.close();

        if (p == 1) {
            System.out.println(0);
        } else {

            int cost = 0;
            while (true) {

                int s = p;
                int q = map.get(p).peek();
                for (int i = 2; i <= m; i++) {
                    if (count[i] == maxp) {
                        if (map.get(i).peek() < q) {
                            s = i;
                            q = map.get(i).peek();
                        }
                    }
                }

                cost += map.get(s).poll();

                count[s]--;
                count[1]++;

                maxp = 0;
                for (int i = 1; i <= m; i++) {
                    if (count[i] >= maxp) {
                        maxp = count[i];
                        p = i;
                    }
                }
                if (p == 1) {
                    System.out.println(cost);
                    return;
                }
            }
        }

    }
}
