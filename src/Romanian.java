public class Romanian {

    StringBuilder leftSide;
    StringBuilder rightSide;
    String sign;
    long lSide = 0, rSide = 0;

    public Romanian(StringBuilder leftSide, StringBuilder rightSide, String sign) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.sign = sign;
    }

    public void Romka() {

        TransToArab trab = new TransToArab();
        TransToRom trom = new TransToRom();

        lSide = trab.RomToArab(leftSide);
        if (lSide < 1 || lSide > 10) {
            throw new IllegalStateException("Цифирям быть должно лишь от I до X включительно! А у вас = " + leftSide);
        }
        rSide = trab.RomToArab(rightSide);
        if (rSide < 1 || rSide > 10) {
            throw new IllegalStateException("Цифирям быть должно лишь от I до X включительно! А у вас = " + rightSide);
        }
        Poschitalka poschitalka = new Poschitalka(lSide, rSide, sign);
        double num = poschitalka.poluchilka();
        if ((sign.equals("-") && rSide >= lSide) || num < 1)
            throw new IllegalStateException("У римлян всё-всё было положительным " +
                    "и больше единицы! Умели же жить люди, а? :-)");
        System.out.println("Для справки: " + lSide + sign + rSide + "=" + (int) num);
        trom.ArabToRom(num);
    }


}