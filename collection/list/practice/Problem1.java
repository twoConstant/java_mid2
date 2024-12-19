package java_mid2.collection.list.practice;


// 아래의 코드를 ArrayList를 사용한 코드로 수정하시오.
public class Problem1 {
    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};

        int total = 0;
        for(int i = 0; i < students.length; i++) {
            total += students[i];
        }

        double average = (double) total / students.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
