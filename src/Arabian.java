public class Arabian {

    StringBuilder leftSide;
    StringBuilder rightSide;
    String sign;
    double lSide = 0, rSide = 0, result = 0;


    public Arabian(StringBuilder leftSide, StringBuilder rightSide, String sign) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.sign = sign;
    }

    public void cifir() {

        rSide = Double.parseDouble(rightSide.toString());
        lSide = Double.parseDouble(leftSide.toString());
        Poschitalka poschitalka = new Poschitalka(lSide, rSide, sign);
        poschitalka.outgone();
    }

}
