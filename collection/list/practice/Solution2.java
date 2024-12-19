package java_mid2.collection.list.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int input = sc.nextInt();
            if(input == 0) {
                break;
            }
            list.add(input);
        }

        // 출력
        for(int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1) {
                System.out.println(list.get(i));
                break;
            }
            System.out.println(list.get(i) + ", ");
        }
    }
}
