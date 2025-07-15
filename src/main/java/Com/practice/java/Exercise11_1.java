package Com.practice.java;

import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int ban;
    int no;
    int kor,eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public String toString() {
        return name + ',' + ban + ',' + no + ',' + kor + ',' + eng + ',' + math + ',' + getTotal() + ',' + getAverage();
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}

class BanNoAscending implements Comparator<Student> {

    @Override
    public int compare(Student s1 , Student s2) {
        if (s1.ban != s2.ban) {
            return s1.ban - s2.ban;
        }
        return s1.no - s2.no;
    }
}

public class Exercise11_1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("홍",1,1,100,100,100));
        list.add(new Student("길",1,2,90,70,80));
        list.add(new Student("남",1,3,80,90,80));
        list.add(new Student("동",1,4,60,90,70));


        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
