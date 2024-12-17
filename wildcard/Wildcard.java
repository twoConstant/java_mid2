package java_mid2.wildcard;

import java_mid2.generic2.animal.Animal;
import java_mid2.wildcard.Box;

    public class Wildcard {
        public static <T> void printGenericV1(Box<T> box) {
            System.out.println(box.get());
    };

    public static void printWildcardV1(Box<?> box) {
		System.out.println(box.get());
    }

    // 와일드카드를 사용하지 못하는 경우
    // 제네릭 메서드를 사용 할 수 밖에 없는 경우
    public static <T> T getBoxValue1(Box<T> box) {
        T value = box.get();    // 타입 매개변수 사용
        return value;
    }

    // 상한 와일드카드 ==> 부모의 타입과 메서드를 사용한다.
    public static Animal getAnimalLowwer(Box<? extends Animal> box) {
        Animal animal = box.get();
        return animal;
    }

    // 하한 와일드카드 ==> 해당 클래스부터 상위 클래스만 받을 수 있다.
    public static Object getAnimalSupper(Box<? super Animal> box) {
        Object animal = box.get();
        return animal;
    }
}
