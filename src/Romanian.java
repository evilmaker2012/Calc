public class Romanian {

    StringBuilder leftSide;
    StringBuilder rightSide;
    String sign;
    int curr, next;
    long lSide = 0, rSide = 0, zSide;

    public Romanian(StringBuilder leftSide, StringBuilder rightSide, String sign) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.sign = sign;
    }

    public void Romka() {

        lSide = RomToArab(leftSide);
        rSide = RomToArab(rightSide);
        Poschitalka poschitalka = new Poschitalka(lSide, rSide, sign);
        if ((sign.equals("-") && rSide >= lSide) || poschitalka.poluchilka() < 0)
            throw new IllegalStateException("У римлян всё-всё было положительным " +
                    "и больше единицы! Умели же жить люди, а? :-)");
        System.out.printf("%.0f", poschitalka.poluchilka());

        ArabToRom(poschitalka.poluchilka());

    }

    private void ArabToRom(double poluchilka) {

    }

    public long RomToArab(StringBuilder sides) {
        zSide = 0;
        int i = 0, len = sides.length(), flagOfRepeat = 1;
        int[] toArab = new int[len];
        // System.out.println(len);
        while (i < len) {
            switch (String.valueOf(sides.charAt(i))) {
                case "i", "I" -> toArab[i] = 1;
                case "v", "V" -> toArab[i] = 5;
                case "x", "X" -> toArab[i] = 10;
                case "l", "L" -> toArab[i] = 50;
                case "c", "C" -> toArab[i] = 100;
                case "d", "D" -> toArab[i] = 500;
                case "m", "M" -> toArab[i] = 1000;
            }
            i++;
        }

        //Поиск повторений V, L, D

        for(int ii = 0; ii <toArab.length; ii++) {
            for (int jj = ii +1; jj <toArab.length; jj++) {
                if(toArab[ii] == 5 && 5==toArab[jj] || toArab[ii] == 50 && 50==toArab[jj] ||toArab[ii] == 500 && 500==toArab[jj]) {
                    throw new IllegalStateException("У римлян повторений V, L, D в одном мегачисле низя никак!");
                }
            }
        }

        // сам перевод в арабские

        for (int j = 0; j < len - 1; j++) {

            curr = toArab[j];
            next = toArab[j + 1];
            if (curr > next) {
                zSide += curr;
                flagOfRepeat = 1;
            }
            if (curr == next) {
                flagOfRepeat++;
                if (flagOfRepeat > 3) {
                    throw new IllegalStateException("У римлян больше трёх справа одинаковых буквоцифирок низя!");
                }
                zSide += curr;
            }
            if (curr < next) {
                if (flagOfRepeat > 1)
                    throw new IllegalStateException("У римлян больше одной одинокой мелкой буквоцифирки низя!");
                zSide -= curr;
            }
        }

        // вывод результата

        System.out.println("Итоговое значение " + sides + " = " + (zSide + toArab[len - 1]));

        return zSide + toArab[len - 1];
    }
}