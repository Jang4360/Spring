package Com.practice.java;

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
    }
}
