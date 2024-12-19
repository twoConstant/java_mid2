package java_mid2.collection.list.batchprocessor;

import java_mid2.collection.list.MyArrayList;

public class BatchProcessorV1 {
    
    private final MyArrayList<Integer> list = new MyArrayList<>();
    
    public void logic(int size) {
        for(int i = 0; i < size; i++) {
            list.add(0, i);
        }
    }
}
