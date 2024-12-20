package java_mid2.set.hashalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HashV3 {
    public static void main(String[] args) {
        int maxNum = 30;
        int playRandNumCnt = 10;

        // 자료구조 구현
        List<Integer>[] arr = new List[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = new ArrayList<>();
        }

        // 입력하기
        Random rnd = new Random();
        for(int i = 0; i < playRandNumCnt; i++) {
            int rndNum = rnd.nextInt(0, maxNum);
            add(arr, rndNum);
            System.out.println(rndNum + " 입력");
        }

        // 상태 출력
        System.out.println(Arrays.toString(arr));    // 아니 이거 되네??

        // 조회하기 20까지
        for(int i = 0; i < maxNum; i++) {
            if(contains(arr, i)) {
                System.out.println(i + " 존재");
            }
        }
    }

    // contains
    private static boolean contains(List<Integer>[] arr, int num) {
        int hashCode = getHashCode(num);

        if(arr[hashCode].isEmpty()) {
            // System.out.println(num + "은 존재하지 않습니다.");
            return false;
        }

        // 일단 있는 경우우
        for(int value : arr[hashCode]) {
            if(value == num) {
                return true;
            }
        }

        // 다 뒤졋는데 없다.
        return false;
    }

    // add
    private static void add(List<Integer>[] arr, int num) {
        // 있는경우 패스스
        if(contains(arr, num)) {
            return;
        }

        // 없는 경우우
        int hashCode = getHashCode(num);
        arr[hashCode].add(num);
    }

    // 해싱
    private static int getHashCode(int num) {
        int hashCode = num % 10;   // 0 ~ 9의 숫자 반환
        return hashCode;
    }
}
