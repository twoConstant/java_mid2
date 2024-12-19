package java_mid2.collection.list;

public interface MyList<T> {
    // size
    int size();
    
    // add
    void add(T e);

    // add
    void add(int index, T e);

    // get
    T get(int index);

    // set
    T set(int index, T e);

    // remove
    T remove(int index);

    // indexOf
    int indexOf(T e);
}
