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
        if(poschitalka.poluchilka()<0) throw new IllegalStateException("У римлян всё-всё было положительным!");
        System.out.println(poschitalka.poluchilka());


    }

    public long RomToArab(StringBuilder sides) {
        zSide = 0;
        int i = 0, len = sides.length();
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
        for (int j = 0; j < len - 1; j++) {
            curr = toArab[j];
            next = toArab[j + 1];
            if (curr < next) {
                zSide -= curr;
            } else {
                zSide += curr;
            }
            // System.out.println(lSide+ "  Итерация = "+j);

        }
        // System.out.println("Итоговое значение "+" = "+(lSide+toArab[len-1]));

        return zSide + toArab[len - 1];
    }
}