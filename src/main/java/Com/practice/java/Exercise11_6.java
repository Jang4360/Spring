package Com.practice.java;

import java.util.*;

public class Exercise11_6 {
    public static void main(String[] args) {
        Set set = new HashSet();
        int[][] board = new int[5][5];

        for (int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random() * 30) + 1 + "");
        }

        List<String> list = new ArrayList<>(set);

        Collections.shuffle(list);

        Iterator<String> it = list.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.parseInt((String) it.next());
                System.out.println((board[i][j]<10?" ": " ")+board[i][j]);
            }
            System.out.println();
        }
    }
}
