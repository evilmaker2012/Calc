import java.util.Scanner;

public class Vvodilka {
    String phrase;

    Scanner sc = new Scanner(System.in);

    public Vvodilka() {
        phrase = sc.nextLine();
        System.out.println(phrase);
    }
}
