public class Sobiralka {
    String phrase;


    public Sobiralka(String phrase) {
        this.phrase = phrase;

    }

    public void SobiralkaBukovok() {
        phrase = phrase.replaceAll("[\s]", "");
        int dlina = phrase.length();
        String[] c = phrase.split("");
        StringBuilder leftSide = new StringBuilder();
        StringBuilder rightSide = new StringBuilder();
        String sign = "";
        int r = 0, a = 0, d = 0;
        for (int i = 0; i < dlina; i++) {
            switch (c[i]) {
                case "i", "I", "v", "V", "x", "X", "l", "L", "c", "C", "d", "D", "m", "M" -> {
//                    System.out.println("Римские! " + c[i]);
                    if (sign.equals(""))
                        leftSide.append(c[i]);
                    else
                        rightSide.append(c[i]);
                    r++;
                }
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
//                    System.out.println("Арабкие! " + c[i]);
                    if (sign.equals(""))
                        leftSide.append(c[i]);
                    else
                        rightSide.append(c[i]);
                    a++;
                }
                case "/", "*", "-", "+", ":" -> {
//                    System.out.println("Знак! " + c[i]);
                    sign = c[i];
                    d++;
                }
                default -> throw new IllegalStateException("нет такой цифры в этой букве: " + c[i]);
            }
        }

        if (a > 0 && r > 0)
            throw new IllegalStateException("У вас тут смесь культур! Я так не умею...");
        if (d == 0 || d > 1)
            throw new IllegalStateException("Что-то тут со знаками действия не то...");


        if (r == 0) {
            Arabian arabian = new Arabian(leftSide, rightSide, sign);
            arabian.cifir();
        }

        if (a == 0) {
            Romanian romanian = new Romanian(leftSide, rightSide, sign);
            romanian.Romka();
        }

    }

}
