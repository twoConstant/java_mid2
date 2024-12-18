package java_mid2.arraylist.MyArrayLists;

import java.util.Arrays;

public class MyArrayListV4<T> {
    private static final int DEFUALT_CAPACITY = 5;

    private Object[] arr;
    private int size = 0;    // 크기와 동시에 비어있는 끝 자리를 나타냄냄

    // // 생성자
    // 1. 기본 생성자, 배열의 크기는 기본 5로 고정
    public MyArrayListV4() {
        arr = new Object[DEFUALT_CAPACITY];
    }

    // 2. 매개변수로 int를 받는 경우 해당 크기로 배열 생성
    public MyArrayListV4(int capacity) {
        arr = new Object[capacity];
    }

    // // 메서드
    // public int size();
    public int size() {
        return size;
    }

    // public void add(Object o);  끝에 추가
    public void add(T o) {
        // 끝자리인경우 추가 길이 갱신
        if(size == arr.length) {
            grow();
        }

        arr[size] = o;
        size++;
    }

    // 코드 추가, 특정 인덱스에 원소추가
    public void add(int index, T o) {
        if(size == arr.length) {
            grow();
        }

        shiftRighttFrom(index);
        arr[index] = o;
        size++;
    }

    // public Object get(int index);
    public T get(int index) {
        return (T)arr[index];
    }

    

    // public Object set(int index, Object o);
    public T set(int index, T o) {
        T oldElement = (T)arr[index];
        arr[index] = o;
        return oldElement;
    }

    // public int indexOf(Object o);
    public int indexOf(T o) {
        for(int i = 0; i < size; i++) {
            if(!arr[i].equals(o)) {
                continue;
            }

            return i;
        }
        return -1;
    }

    // 동적 배열 할당 기능, 현재 size대비 100%증가
    private void grow() {
        int newSize = size * 2;;
        arr = Arrays.copyOf(arr, newSize);
    }

    // 코드 추가, 특정 인덱스 삭제, 삭제 대상 반환
    public T remove(int index) {
        T deletedElement = (T)arr[index];
        shiftLeftFrom(index);
        size--;
        return deletedElement;
    }

    // 코드 추가, 특정 인덱스 기준 뒤의 모든 원소를 한칸 왼쪽으로 이동
    private void shiftLeftFrom(int index) {
        for(int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // 코드 추가, 특정 인덱스 기준 앞의 모든 원소를 한칸 오른쪽으로 이동동
    private void shiftRighttFrom(int index) {
        for(int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
    }

    // @Override
    // public void toString();
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size)) + " size=" + size +
        ", capacity=" + arr.length;
    }
}
