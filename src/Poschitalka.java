public class Poschitalka {
    String sign;
    double lSide = 0, rSide = 0, result=0;

    public Poschitalka(double lSide, double rSide, String sign) {
        this.lSide = lSide;
        this.rSide = rSide;
        this.sign = sign;
    }

    public void outgone() {
        System.out.printf("%.0f",poluchilka());
    }
       public double poluchilka() {
           switch (sign) {
               case "+"->
                       result = (lSide + rSide);
               case "-"->
                       result = (lSide - rSide);
               case ":", "/"->
                       result = (lSide / rSide);
               case "*"->
                       result = (lSide * rSide);
               default -> System.out.println("Ку, дядя Вова!");
           }
           return result;
       }
}