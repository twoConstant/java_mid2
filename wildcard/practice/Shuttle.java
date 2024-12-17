package java_mid2.wildcard.practice;

public class Shuttle <T extends BioUnit> {
    
    private T unit;
    
    public void in(T unit) {
        this.unit = unit;
    }

    public void showInfo(){
        System.out.println(unit.toString());
    }

    public T out() {
        return unit;
    }
}
