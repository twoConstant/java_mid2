package java_mid2.generic1;

public class practice1 {

        // 제네릭 클래스 생성
        private static class Container<T> {
            private T item;

            public void setItem(T value) {
                this.item = value;
            }

            public T getItem() {
                return this.item;
            }

            public boolean isEmpty() {
                return item == null;
            }
        }
        
    public static void main(String[] args) {
        
    }
}
