public class TransToArab {

    int curr, next;
    long zSide;

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

//        System.out.println("Итоговое значение " + zSide);

        return zSide;

    }
}
