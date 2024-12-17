package java_mid2.wildcard.practice;

public class UnitPrinter {
    
    // printV1 : 제네릭 메서드로 구현
    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
        T unit = shuttle.out();
        System.out.println(unit.toString());
    }

    // printV2 : 와일드카드로 구현현
    public static void printV2(Shuttle<? extends BioUnit> shuttle) {
        BioUnit unit = shuttle.out();
        System.out.println(unit.toString());
    }
}
