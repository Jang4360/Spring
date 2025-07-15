package Com.practice.java;

public class Exercise_8 {
    public static void main(String[] args) {
        Card c1 = new Card(1,2,3);
        Card c2 = new Card(1,2,3);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));

    }
}

class Card{
    int x,y,z;

    Card() {
        this(0,0,0);
    }

    Card(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Card card = (Card) object;
        return x == card.x &&  y == card.y &&  z == card.z;
    }

    @Override
    public String toString() {
        return "Card{" + "x=" + x + ", y=" + y + ", z=" + z + "}";
    }
}


