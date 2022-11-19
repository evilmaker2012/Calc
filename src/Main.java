public class Main {
    //TODO sf
    public static void main(String[] args) {
        Vvodilka vvodilka = new Vvodilka();
        Sobiralka tt = new Sobiralka(vvodilka.phrase);
        tt.SobiralkaBukovok();
    }

}