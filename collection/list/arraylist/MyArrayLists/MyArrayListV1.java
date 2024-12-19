package java_mid2.collection.list.arraylist.MyArrayLists;

import java.util.Arrays;

// 동적 배열 기능이 없는 단계계
public class MyArrayListV1 {
    private static final int DEFUALT_CAPACITY = 5;

    private Object[] arr;
    private int size = 0;    // 크기와 동시에 비어있는 끝 자리를 나타냄냄

    // // 생성자
    // 1. 기본 생성자, 배열의 크기는 기본 5로 고정
    public MyArrayListV1() {
        arr = new Object[DEFUALT_CAPACITY];
    }

    // 2. 매개변수로 int를 받는 경우 해당 크기로 배열 생성
    public MyArrayListV1(int capacity) {
        arr = new Object[capacity];
    }

    // // 메서드
    // public int size();
    public int size() {
        return size;
    }

    // public void add(Object o);  끝에 추가
    public void add(Object o) {
        arr[size] = o;
        size++;
    }

    // public Object get(int index);
    public Object get(int index) {
        return arr[index];
    }

    // public Object set(int index, Object o);
    public Object set(int index, Object o) {
        Object oldElement = arr[index];
        arr[index] = o;
        return oldElement;
    }

    // public int indexOf(Object o);
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(!arr[i].equals(o)) {
                continue;
            }

            return i;
        }
        return -1;
    }

    // @Override
    // public void toString();
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size)) + " size=" + size +
        ", capacity=" + arr.length;
    }
}
