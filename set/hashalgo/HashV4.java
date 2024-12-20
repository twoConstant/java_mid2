package java_mid2.set.hashalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// 문자열 해싱싱
public class HashV4 {
    public static void main(String[] args) {
        int playRandNumCnt = 10;

        // 자료구조 구현
        List<String>[] arr = new List[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new ArrayList<>();
        }

        // 입력하기
        Random rnd = new Random();
        for (int i = 0; i < playRandNumCnt; i++) {
            String rndStr = generateRandomString(rnd, 5); // 랜덤 문자열 생성 (길이 5)
            add(arr, rndStr);
            System.out.println(rndStr + " 입력");
        }

        // 상태 출력
        System.out.println(Arrays.toString(arr)); // 자료구조 상태 출력

        // 조회 테스트
        String testStr1 = "hello";
        String testStr2 = "world";

        add(arr, testStr1);
        System.out.println(testStr1 + " 입력");

        if (contains(arr, testStr1)) {
            System.out.println(testStr1 + " 존재");
        } else {
            System.out.println(testStr1 + " 존재하지 않음");
        }

        if (contains(arr, testStr2)) {
            System.out.println(testStr2 + " 존재");
        } else {
            System.out.println(testStr2 + " 존재하지 않음");
        }
    }

    // contains
    private static boolean contains(List<String>[] arr, String str) {
        int hashCode = getHashCode(str);

        if(arr[hashCode].isEmpty()) {
            // System.out.println(num + "은 존재하지 않습니다.");
            return false;
        }

        // 일단 있는 경우우
        for(String value : arr[hashCode]) {
            if(value.equals(str)) {
                return true;
            }
        }

        // 다 뒤졋는데 없다.
        return false;
    }

    // add
    private static void add(List<String>[] arr, String str) {
        // 있는경우 패스스
        if(contains(arr, str)) {
            return;
        }

        // 없는 경우우
        int hashCode = getHashCode(str);
        arr[hashCode].add(str);
    }

    // 해싱
    private static int getHashCode(String str) {
        int numRepresentStr = 0;
        for(int i = 0; i < str.length(); i++) {
            numRepresentStr += str.charAt(i);
        }
        int hashCode = numRepresentStr % 10;   // 0 ~ 9의 숫자 반환
        return hashCode;
    }

    // 랜덤 문자열 생성
    private static String generateRandomString(Random rnd, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + rnd.nextInt(26)); // a ~ z 랜덤 문자 생성
            sb.append(c);
        }
        return sb.toString();
    }
}
