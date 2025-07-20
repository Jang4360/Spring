package Com.practice.java;

import java.util.*;

public class Exercise_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tc = 1; tc<=t; tc++){
            int n = scanner.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }

            String[] r90 = new String[n];
            String[] r180 = new String[n];
            String[] r270 = new String[n];

            for (int i = 0; i<n; i++) {
                StringBuilder sb90 = new StringBuilder();
                StringBuilder sb180 = new StringBuilder();
                StringBuilder sb270 = new StringBuilder();
                for (int j = n-1; j>=0; j--) {
                    sb90.append(board[j][i]);
                    sb180.append(board[n-1-i][j]);
                    sb270.append(board[n-1-j][n-1-i]);
                }
                r90[i] = sb90.toString();
                r180[i] = sb180.toString();
                r270[i] = sb270.toString();
            }

            for (int i = 0; i < n; i++) {
                System.out.println(r90[i] + " " + r180[i] + " " + r270[i]);
            }

        }
    }
}
