package Com.practice.java;

import java.util.*;

class Print{
    public static String delimiter;
    public static void A() {
        delimiter = "---";
        System.out.println(delimiter);
        System.out.println("A");
        System.out.println("B");
    }
    public static void B(){
        delimiter = "***";
        System.out.println(delimiter);
        System.out.println("A");
        System.out.println("B");
    }
}
public class Exercise_14 {
    public static void main(String[] args) {
        Print.A();
        Print.B();

        HashSet<String> set1 = new HashSet<>(Arrays.asList("1","2","3"));
        HashSet<String> set2 = new HashSet<>(Arrays.asList("3","4","5","6","7"));
        set1.addAll(Arrays.asList("8","9"));
        set1.remove("3");

        enum CoffeeType{

        }
        System.out.println(set1);
    }
}
