package java_mid2.wildcard.practice;

public class Main {
    public static void main(String[] args) {
        Marine marine1 = new Marine("마린1", 40);
        Marine marine2 = new Marine("마린2", 50);
        Marine resultMarine = UnitUtil.maxHp(marine1, marine2);
        System.out.println("resultMarine = " + resultMarine);

        Zealot zealot1 = new Zealot("질럿1", 100);
        Zealot zealot2 = new Zealot("질럿2", 150);
        Zealot resultZealot = UnitUtil.maxHp(zealot1, zealot2);
        System.out.println("resultZealot = " + resultZealot);

        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(marine1);
        shuttle1.showInfo();

        UnitPrinter.printV1(shuttle1);
        UnitPrinter.printV2(shuttle1);
    }
}
