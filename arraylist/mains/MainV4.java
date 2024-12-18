package java_mid2.arraylist.mains;

import java_mid2.arraylist.MyArrayLists.MyArrayListV4;

public class MainV4 {
    public static void main(String[] args) {
        MyArrayListV4<String> list = new MyArrayListV4<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String string = list.get(0);
        System.out.println("string = " + string);

        MyArrayListV4<Integer> list_integer = new MyArrayListV4<>();
        list_integer.add(1);
        list_integer.add(2);
        list_integer.add(3);
        Integer integer = list_integer.get(0);
        System.out.println("integer = " + integer);

    }
}
