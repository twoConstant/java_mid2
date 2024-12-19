package java_mid2.collection.list.batchprocessor;

import java_mid2.collection.list.MyArrayList;
import java_mid2.collection.list.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        // MyArrayList 구현체를 활용한 배치프로세서 생성
        BatchProcessorV3 batchProcessor_arrList = new BatchProcessorV3(new MyArrayList<>());
        // MyLinkedList 구현체를 활용한 배치프로세서 생성
        BatchProcessorV3 batchProcessor_linkedList = new BatchProcessorV3(new MyLinkedList<>());

        // 각각 logic 메서드 수행행
        int size = 50_000;
        batchProcessor_arrList.logic(size);    // 크기: 50000, 계산 시간: 1411ms
        batchProcessor_linkedList.logic(size);    // 크기: 50000, 계산 시간: 11ms
    }
}
