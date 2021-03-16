package com.yifan.dynamicprogramming;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeMate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(countPrimePairs(arr));
        }

        scanner.close();
    }

    private static boolean isPrime(int n, Set<Integer> set) {
        if (set.contains(n)) {
            System.out.println(n);
            return true;
        }
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        System.out.println(n);
        set.add(n);
        return true;
    }

    private static int countPrimePairs(int[] v) {

        Set<Integer> set = new HashSet<>();

        int[] dp = new int[v.length + 1];

        for (int i = v.length - 2; i > -1; i--) {
            for (int j = v.length - 1; j > i; j--) {
                int cnt = isPrime(v[i] + v[j], set) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1) : dp[i + 1];
                dp[i] = Math.max(cnt, dp[i]);
            }
        }


        return dp[0];

    }
}
