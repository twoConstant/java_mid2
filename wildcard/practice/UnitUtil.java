package java_mid2.wildcard.practice;

public class UnitUtil {
    
    // maxHp()의 정적 메서드 조건은 아래와 같다.
    // - 두 유닛을 입력받아 체력이 높은 유닛을 반환, 단 체력이 같은 경우 둘중 아무나 반환해도 된다.
    // - 제네릭 메서드를 사용해야한다.
    // - 입력하는 유닛의 타입과 반환하는 유닛의 타입이 같아야한다.

    public static <T extends BioUnit> T maxHp(T unit1, T unit2) {
        if(unit1.getHp() >= unit2.getHp()) {
            return unit1;
        } else {
            return unit2;
        }
    }
}
