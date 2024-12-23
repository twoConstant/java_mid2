package java_mid2.set.myset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyHashSetV1 implements IMyHashSetV1{

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private LinkedList<Integer>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    // 기본 생성자
    public MyHashSetV1() {
        initBucket();
    }

    // 생성자
    public MyHashSetV1(int capacity) {
        this.capacity = capacity;
        initBucket();
    }

    @Override
    public void initBucket() {
        buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public boolean add(int value) {
        // 해시 코드를 얻는다.
        int hashIndex = hashIndex(value);
        // bucket[hashCode]에 동일한 값이 있는지 찾는다.
        for(int num : buckets[hashIndex]) {
            if(num == value) {
                return false;
            }
        }
        // 없으면 추가
        buckets[hashIndex].add(value);
        size++;
        return true;
    }

    @Override
    public boolean contains(int searchValue) {
        int hashIndex = hashIndex(searchValue);
        for(int num : buckets[hashIndex]) {
            if(num == searchValue) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int value) {
        int hashIndex = hashIndex(value);
        for(int i = 0; i < buckets[hashIndex].size(); i++) {
            if(buckets[hashIndex].get(i) == value) {
                buckets[hashIndex].remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashIndex(int value) {
        return value % capacity;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                '}';
    }
}
