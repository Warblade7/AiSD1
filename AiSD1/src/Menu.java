import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {

    static ArrayList<Karta> karty;

    public static void stworzListe() {
        if (karty == null) {
            karty = new ArrayList<>();
        } else
            karty.clear();
        karty.add(new Karta(1, 0));
        karty.add(new Karta(1, 0));
        karty.add(new Karta(1, 0));
    }

    public static void wyswietlListe() {
        for (int i = 0; i < karty.size(); i++) {
            System.out.println((i + 1) + " - " + karty.get(i));
        }
    }

    public static void wyswietlWartosc() {
        Scanner s = new Scanner(System.in);

        System.out.println("");
        System.out.println("Jakie karty chcesz wyswietlic?");
        System.out.println("2-10 - karty odpowiadajace");
        System.out.println("1 - as");
        System.out.println("11 - walet");
        System.out.println("12 - dama");
        System.out.println("13 - krol");
        System.out.println("");

        boolean a = true;
        int w = 0;
        try {
            w = s.nextInt();
            if (w > 13 || w < 1)
                throw new Exception();
        } catch (Exception e) {
            System.err.println("Zly input");
            a = false;
        }

        if (a) {
            Iterator<Karta> iter = karty.iterator();
            Karta x;
            int ile = 1;
            while (iter.hasNext()) {
                x = iter.next();
                if (x.getWartosc() == w) {
                    System.out.println(ile + " - " + x);
                    ile++;
                }
            }
        }
    }

    public static void wyswietlKolor() {

        Scanner s = new Scanner(System.in);

        //System.out.println("");
        System.out.println("Jaki kolor kart wyswietlic");
        System.out.println("0 - kier");
        System.out.println("1 - karo");
        System.out.println("2 - trefl");
        System.out.println("3 - pik");
        System.out.println("");

        boolean a = true;
        int k = 0;
        try {
            k = s.nextInt();
            if (k > 3 || k < 0)
                throw new Exception();
        } catch (Exception e) {
            System.err.println("Zly input");
            a = false;
        }

        if (a) {
            Iterator<Karta> iter = karty.iterator();
            Karta x;
            int ile = 1;
            while (iter.hasNext()) {
                x = iter.next();
                if (x.getKolor() == k) {
                    System.out.println(ile + " - " + x);
                    ile++;
                }
            }
        }
    }

    public static int ileElementow() {
        return karty.size();
    }

    public static void wstawKarte(Karta k) {
        boolean c = true;
        for (Karta z : karty) {
            if ((z.getWartosc() > k.getWartosc() || (z.getKolor() > k.getKolor() && z.getWartosc() == k.getWartosc())) && c) {
                karty.add(karty.indexOf(z), k);
                c = false;
                break;
            }
        }
        if (c)
            karty.add(k);
    }


    public static void dodajKarty() {
        Karta b;
        while (true) {
            b = Karta.wylosuj();

            if (b.getWartosc() == 0)
                break;
            else
                wstawKarte(b);
        }
    }

    public static void usunDuplikaty() {
        ArrayList<Karta> arr = karty;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1).equals(arr.get(i)))
                arr.set(i - 1, null);
        }
        while (arr.contains(null)) {
            arr.remove(null);
        }
        karty = arr;
    }

    public static void main(String[] args) {
        stworzListe();
        boolean loop=true;

        while (loop==true) {

            System.out.println("1 - Stworz liste");
            System.out.println("2 - wyswietl liste");
            System.out.println("3 - ile elementow");
            System.out.println("4 - wyswietl karty o podanej wartosci");
            System.out.println("5 - wyswietl karty o podanym kolorze");
            System.out.println("6 - usun powtarzajace sie karty");
            System.out.println("7 - wyjdz z programu");

            Scanner scan = new Scanner(System.in);

            String w = scan.nextLine();
            if (w.length() > 1) {
                System.err.println("Zly input");
                System.out.println("");
                continue;
            }
            switch (w) {
                default:
                    System.err.println("Zly input");
                    System.out.println("");
                    break;
                case ("1"):
                    stworzListe();
                    dodajKarty();
                    System.out.println("Stworzono liste");
                    break;
                case ("2"):
                    //System.out.println("");
                    wyswietlListe();
                    System.out.println("");
                    break;
                case ("3"):
                    System.out.println("Na liscie jest " + ileElementow() + " elementow");
                    break;
                case ("4"):
                    wyswietlWartosc();
                    break;
                case ("5"):
                    wyswietlKolor();
                    break;
                case ("6"):
                    usunDuplikaty();
                    System.out.println("Usunieto duplikaty");
                    break;
                case ("7"):
                    loop=false;
                    break;

            }
        }

    }

}
