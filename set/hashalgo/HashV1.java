package java_mid2.set.hashalgo;

import java.util.Random;

// index를 활용한 헤시 알로리즘 구현하기
public class HashV1 {
    public static void main(String[] args) {
        // 컨셉 value와 index를 매핑시켜 바로 arr[value] != null이면 존재
        int size = 100;    // 생성되는 난수의 최대값 - 1
        Integer[] arr = new Integer[size];
        Random rnt = new Random();
        for(int i = 0; i < 10; i++) {
            int inputNum = rnt.nextInt(0, size);
            System.out.println("inputNum: " + inputNum);
            arr[inputNum] = inputNum;
        }

        // 조회
        StringBuilder sb = new StringBuilder();
        for(int i =  0; i < size; i++) {
            if(arr[i] == null) {
                sb.append("null, ");
                continue;
            }
            sb.append(i + ", ");
        }
        System.out.println(sb.toString());
    }
}
