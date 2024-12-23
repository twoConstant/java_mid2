package java_mid2.set.myset;

public interface IMyHashSetV1 {
    // 상수만 정의
    int DEFAULT_INITIAL_CAPACITY = 16;

    // 메서드 정의
    void initBucket();
    // 있으면 false, 없으면 false
    boolean add(int value);
    boolean contains(int searchValue);
    boolean remove(int value);
    int hashIndex(int value);
    int getSize();
    String toString();
}
