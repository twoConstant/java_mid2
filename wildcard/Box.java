package java_mid2.wildcard;

public class Box<T> {
    T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
