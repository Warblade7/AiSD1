
import java.util.Random;

public class Karta {

    private int wartosc, kolor;

    static Random rand = new Random();

    public Karta() {
        wartosc = rand.nextInt(14);
        kolor = rand.nextInt(4);
    }

    public Karta(int wartosc, int kolor) {
        this.wartosc=wartosc;
        this.kolor=kolor;
    }

    public int getWartosc() {
        return wartosc;
    }

    public int getKolor() {
        return kolor;
    }

    public static Karta wylosuj() {
        return new Karta();
    }

    public String toString() {

        String w,k;

        switch(wartosc) {
            default:
                w=String.valueOf(wartosc);
                break;
            case(1):
                w="As";
                break;
            case(11):
                w="Walet";
                break;
            case(12):
                w="Dama";
                break;
            case(13):
                w="Krol";
                break;
        }

        switch(kolor) {
            default:
                k="kier";
                break;
            case(1):
                k="karo";
                break;
            case(2):
                k="trefl";
                break;
            case(3):
                k="pik";
                break;
        }

        return w + " " + k;
    }

    @Override
    public boolean equals(Object a) {
        Karta b = (Karta) a;
        return wartosc == b.getWartosc() && kolor == b.getKolor();
    }

}
