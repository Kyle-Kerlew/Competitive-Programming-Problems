/**
 * Problem
 * Charles defines the goodness score of a string as the number of indices i such that Si≠SN−i+1 where 1≤i≤N/2 (1-indexed). For example, the string CABABC has a goodness score of 2 since S2≠S5 and S3≠S4.
 * <p>
 * Charles gave Ada a string S of length N, consisting of uppercase letters and asked her to convert it into a string with a goodness score of K. In one operation, Ada can change any character in the string to any uppercase letter. Could you help Ada find the minimum number of operations required to transform the given string into a string with goodness score equal to K?
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 * <p>
 * The first line of each test case contains two integers N and K. The second line of each test case contains a string S of length N, consisting of uppercase letters.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the minimum number of operations required to transform the given string S into a string with goodness score equal to K.
 * <p>
 * Limits
 * Memory limit: 1 GB.
 * 1≤T≤100.
 * 0≤K≤N/2.
 * Test Set 1
 * Time limit: 20 seconds.
 * 1≤N≤100.
 * Test Set 2
 * Time limit: 40 seconds.
 * 1≤N≤2×105 for at most 10 test cases.
 * For the remaining cases, 1≤N≤100.
 */

import java.util.Scanner;

public class KGoodness {

    private int getGoodnessScore(String s, int n) {
        int count = 0;
        char[] letters = s.toCharArray();
        for (int i = 1; i <= Math.floorDiv(n, 2); i++) {
            if (letters[i - 1] != letters[n - i]) {
                count++;
            }
        }
        return count;
    }


    private int getMoveCounts(int k, int result) {
        if (result == k) {
            return 0;
        }
        int moveCounts = 0;
        if (k > result) {
            moveCounts = k - result;
        }
        if (k < result) {
            moveCounts = result - k;
        }
        return moveCounts;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println("Case #" + i + ": " + solution.getMoveCounts(k, solution.getGoodnessScore(s, n)));
        }
    }
}
