package java_mid2.generic2.main;

import java_mid2.generic2.animal.Cat;
import java_mid2.generic2.animal.Dog;
import java_mid2.generic2.hospital.HospitalV1;

public class MainForV1 {
    public static void main(String[] args) {
        HospitalV1 dogHospital = new HospitalV1();
        HospitalV1 catHospital = new HospitalV1();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제1: 개 병원에 고양이 전달
        dogHospital.set(cat); // 매개변수 체크 실패: 컴파일 오류가 발생하지 않음

        // 문제2: 개 타입 반환, 캐스팅 필요
        dogHospital.set(dog);
        Dog biggerDog = (Dog) dogHospital.getBigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}

