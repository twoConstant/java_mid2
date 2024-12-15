package java_mid2.gengeric_method;

import java_mid2.generic2.animal.Animal;

public class HospitalV4 {

    public static <T extends Animal> void checkup(T animal) {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public static <T extends Animal> T getBigger(T a, T b) {
        return a.getSize() > b.getSize() ? a : b;
    }
}
