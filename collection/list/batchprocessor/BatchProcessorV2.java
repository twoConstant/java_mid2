package java_mid2.collection.list.batchprocessor;

import java_mid2.collection.list.MyLinkedList;

public class BatchProcessorV2 {
    private final MyLinkedList<Integer> list = new MyLinkedList<>();
    
    public void logic(int size) {
        for(int i = 0; i < size; i++) {
            list.add(0, i);
        }
    }
}
