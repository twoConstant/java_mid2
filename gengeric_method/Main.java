package java_mid2.gengeric_method;

import java_mid2.generic2.animal.Cat;
import java_mid2.generic2.animal.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("깜", 100);
        Cat cat = new Cat("위키", 50);

        HospitalV4.checkup(dog);
        HospitalV4.checkup(cat);

        Dog targetDog = new Dog("돌", 200);
        Dog biggerDog = HospitalV4.getBigger(dog, targetDog);
        System.out.println("bigger: " + biggerDog);
    }
}
