package java_mid2.collection.list.practice;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < students.length; i++) {
            list.add(students[i]);
        }


        int total = 0;
        for(int i = 0; i < students.length; i++) {
            total += list.get(i);
        }

        double average = (double) total / list.size();
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
