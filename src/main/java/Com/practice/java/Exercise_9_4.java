package Com.practice.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Exercise_9_4 {
    public static void main(String[] args) {
        String[] phoneNumber = {
                "010-3456-7890",
                "011-1111-1111",
                "022-2222-1111"
        };

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print(">> ");
            String input = s.nextLine().trim();

            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0);
            } else if (input.equals("0")) {
                // 전체 전화번호 출력
                System.out.println(Arrays.toString(phoneNumber));
                continue;  // 다음 입력 받기
            }

            boolean found = false;  // 검색 결과 플래그

            for (int i = 0; i < phoneNumber.length; i++) {
                String number = phoneNumber[i].replace("-", "");
                if (number.contains(input)) {
                    System.out.println(phoneNumber[i]);  // 원본 번호 출력
                    found = true;
                }
            }

            if (!found) {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    }
}
