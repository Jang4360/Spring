package Com.practice.java;

public class Exercise_9 {
    public static int count(String src, String target) {
        int count = 0;
        int pos = 0;

        int t = target.length();
        if (src.length() < t) return 0;
        for (int i = pos; i<=src.length()-t; i++) {
            if (src.substring(i,i+t).equals(target)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB","AB"));
        System.out.println(count("12345","AB"));
    }

}
