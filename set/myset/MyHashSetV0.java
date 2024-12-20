package java_mid2.set.myset;

import java.util.Arrays;

// 배열을 통한 set 구현
public class MyHashSetV0 {
    
    private int arr[] = new int[10];
    private int size = 0;

    public void add(int e) {
        arr[size] = e;
        size++;
    }

    public boolean contains(int e) {
        for(int i = 0; i < size; i++) {
            if(arr[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(arr, size)) +
                ", size=" + size +
                '}';
    }

}
