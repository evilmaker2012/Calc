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
        double num = poschitalka.poluchilka();
        if ((sign.equals("-") && rSide >= lSide) || num < 0)
            throw new IllegalStateException("У римлян всё-всё было положительным " +
                    "и больше единицы! Умели же жить люди, а? :-)");
        ArabToRom(num);
        System.out.printf("%.0f", num);
    }

    protected void ArabToRom(double poluchilka) {
        // 1000 100 10 1
        StringBuilder toRomka = new StringBuilder();
        int stepen = (int) Math.floor(Math.log10(poluchilka)), razryad, rep, excl;


        for (int i = stepen; i >= 0; i--) {
            razryad = (int) Math.pow(10, i);
            rep = (int) Math.floor(poluchilka / razryad);
            if (i < stepen) {
                rep = (int) Math.floor(poluchilka / razryad) - (int) Math.pow(10, stepen - i);

            }

            if (rep >= 0) {
                excl = rep * razryad;
                switch (excl) {
                    case 900 -> toRomka.append("CM");
                    case 500 -> toRomka.append("D");
                    case 400 -> toRomka.append("CD");
                    case 90 -> toRomka.append("XC");
                    case 50 -> toRomka.append("L");
                    case 40 -> toRomka.append("XL");
                    case 9 -> toRomka.append("IX");
                    case 5 -> toRomka.append("V");
                    case 4 -> toRomka.append("IV");
//                    default -> throw new IllegalStateException("R");
                }
//                System.out.println(toRomka);


                while (rep > 0 && rep < 4) {
                    switch (razryad) {
                        case 1000 -> toRomka.append("M");
                        case 100 -> toRomka.append("C");
                        case 10 -> toRomka.append("X");
                        case 1 -> toRomka.append("I");
//                        default -> throw new IllegalStateException("R");
                    }
                    rep--;
//                    System.out.println(toRomka);

                }
            }
        }

        System.out.println("Итоговый Роман = " + toRomka);
        System.out.println();

    }

    public long RomToArab(StringBuilder sides) {
        zSide = 0;
        int i = 0, k = 0, len = sides.length(), flagOfRepeat = 1;
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

        for (int ii = 0; ii < toArab.length; ii++) {
            for (int jj = ii + 1; jj < toArab.length; jj++) {
                if (Math.abs(ii - jj) == 1) {
                    if (toArab[ii] == 5 && 5 == toArab[jj] || toArab[ii] == 50 && 50 == toArab[jj] || toArab[ii] == 500 && 500 == toArab[jj]) {
                        throw new IllegalStateException("У римлян повторений V, L, D в одном мегачисле низя никак!");
                    }
                }

            }
        }

        // сам перевод в арабские

        if (len > 2) {
            while (k < len - 2) {
                if (toArab[k] < toArab[k + 1] && toArab[k + 1] < toArab[k + 2])
                    throw new IllegalStateException("Нелья, чтобы больше одной мелкой стояло перед одной крупной!");
                k++;
            }
        }
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

        zSide = len == 1 ? toArab[0] : zSide + toArab[len - 1];

        System.out.println("Итоговое значение " + zSide);

        return zSide;

    }
}