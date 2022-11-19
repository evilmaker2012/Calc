public class Arabian {

    StringBuilder leftSide;
    StringBuilder rightSide;
    String sign;
    double lSide = 0, rSide = 0;


    public Arabian(StringBuilder leftSide, StringBuilder rightSide, String sign) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.sign = sign;
    }

    public void cifir() {

        rSide = Double.parseDouble(rightSide.toString());
        if (rSide < 1 || rSide > 10) {
            throw new IllegalStateException("Цифирям быть должно лишь от 1 до 10 включительно! А у вас = "+(int)rSide);
        }
        lSide = Double.parseDouble(leftSide.toString());
        if (lSide < 1 || lSide > 10) {
            throw new IllegalStateException("Цифирям быть должно лишь от 1 до 10 включительно! А у вас = "+(int)lSide);
        }
        Poschitalka poschitalka = new Poschitalka(lSide, rSide, sign);
        System.out.printf("Итоговый Арабчонок = "+"%.0f",poschitalka.poluchilka());
    }

}
