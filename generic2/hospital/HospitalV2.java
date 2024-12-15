package java_mid2.generic2.hospital;

import java_mid2.generic2.animal.Animal;

public class HospitalV2<T> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        // System.out.println("동물 이름: " + animal.getName());
        // System.out.println("동물 크기: " + animal.getSize());
        // animal.sound();
    }

    // public Animal getBigger(Animal target) {
        // return animal.getSize() > target.getSize() ? animal : target;
    // }
}
