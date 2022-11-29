public class TransToRom {
    protected void ArabToRom(double poluchilka) {
        StringBuilder toRomka = new StringBuilder();


//        вычисляю экпоненту в арабском числе
        int stepen = (int) Math.floor(Math.log10(poluchilka)), razryad, rep, excl;

//        использую эту отнформацию, чтобы пройти по каждой цифре арабского числа
        for (int i = stepen; i >= 0; i--) {

//            вычисляю разряд числа: единицы, десятки, сотни, тысячи
            razryad = (int) Math.pow(10, i);

//            вычисляю первое число соответствующего разряда: 345:100=3
//            Оно же число повторений для сбора удиниц, десятков и т.д.
            rep = (int) Math.floor(poluchilka / razryad);

//            вычисляю следующее число для обработки уже без предыдущего разряда: 345-3*100=45, и оно
//            уже пойдёт в обработку на слудующем шаге работы с экспонентой, котрая тоже уменьшится на 1
            poluchilka = i ==0 ? poluchilka = poluchilka % 10 : poluchilka- rep * razryad;

//            ищу "неповторимые" цифры
            if (rep >= 0) {

                if (rep > 5 && rep <= 8) {
                    excl = (rep-(rep-5))* razryad;
                    rep-=5;
                }else excl=rep * razryad;

                switch (excl) {
                    case 900 -> toRomka.append("CM");
                    case 500 -> toRomka.append("D");
                    case 400 -> toRomka.append("CD");
                    case 90 -> toRomka.append("XC");
                    case 50 -> toRomka.append("L");
                    case 40 -> toRomka.append("XL");
                    case 9 -> toRomka.append("IX");
                    case 8 -> toRomka.append("VIII");
                    case 7 -> toRomka.append("VII");
                    case 6 -> toRomka.append("VI");
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
        System.out.println("Вот перевод ответа в арабские: "+new TransToArab().RomToArab(toRomka));
    }
}
