package java_mid2.set.hashalgo;

import java.util.Random;

// 나머지 연산을 활용, 해시 충돌은 고려하지 않음
public class HashV2 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        
        // 저장장
        Integer[] inputNums = {1, 29, 35, 27, 36};
        for(int num : inputNums) {
            // 해싱
            int hashCode = getHashCode(num);
            // 해시 코드를 인덱스로 하여 값 저장장
            arr[hashCode] = num;
        }

        // 조회
        for(int num : inputNums) {
            int hashCode = getHashCode(num);
            if(arr[hashCode] != null) {
                // 해시 코드를 통해 해당 인덱스에 접근하여 조회를 수행행
                System.out.print(arr[hashCode] + ", ");
            }
        } 
    }

    // 해싱 알고리즘
    private static int getHashCode(int num) {
        int hashCode = num % 10;   // 0 ~ 9의 숫자 반환
        return hashCode;

    }
}