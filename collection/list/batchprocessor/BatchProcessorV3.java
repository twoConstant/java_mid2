package java_mid2.collection.list.batchprocessor;

import java_mid2.collection.list.MyList;

public class BatchProcessorV3 {
    
    // 구현체가 아닌 인터페이스에 의존
    private final MyList<Integer> list;
    
    public BatchProcessorV3(MyList<Integer> myList) {
        this.list = myList;
    }

    public void logic(int size) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}
