package java_mid2.generic2.main;

import java_mid2.generic2.animal.Cat;
import java_mid2.generic2.animal.Dog;
import java_mid2.generic2.hospital.HospitalV3;

public class MainForV3 {
    public static void main(String[] args) {
        HospitalV3<Dog> dogHospital = new HospitalV3<>();
        HospitalV3<Cat> catHospital = new HospitalV3<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        //개 병원
        dogHospital.set(dog);
        dogHospital.checkup();

        //고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제1 해결: 개 병원에 고양이 전달
        // dogHospital.set(cat); // 다른 타입 입력: 컴파일 오류

        // 문제2 해결: 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog = dogHospital.getBigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}
