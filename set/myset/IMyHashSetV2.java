package java_mid2.set.myset;

public interface IMyHashSetV2 {
    boolean add(Object value);
    boolean contains(Object searchValue);
    boolean remove(Object value);
    int hashIndex(Object value);
    int getSize();
    String toString();
}
