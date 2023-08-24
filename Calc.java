import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите арифметическое выражение: ");
        String input = scanner.nextLine();
        scanner.close();
        int a, b, result;
        String znak, type;

        String[] elements = input.split(" ");
        if (elements.length != 3) { // проверяем что 2 числа в примере и один знак
            throw new IllegalArgumentException("Неверный формат выражения");
        }
        if (isArabic(elements[0]) && isArabic(elements[2])){
            type = "arabic";
        } else if (isRoman(elements[0]) && isRoman(elements[2])){
            type = "roman";
        } else {
            throw new IllegalArgumentException("Неверный формат выражения");
        }
        a = toInt(elements[0]);  //преобразовываем полученный элемент строки в арабское число
        b = toInt(elements[2]);
        znak = elements[1];
        result = calculate(a, b, znak);
       if (result > 0 && type.equals("roman")){
           System.out.println("Ответ: " + toRoman(result));
       } else if(type.equals("arabic")){
           System.out.println("Ответ: " + result);
       } else  {
           throw new IllegalArgumentException("Недопустимый ответ");
       }
    }

    public static boolean isArabic(String s) { // проверка на арабские числа
        String[] arabicArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for(int i = 0; i < arabicArray.length; i++ ){
            if (s.equals(arabicArray[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean isRoman(String s) { // проверка на римские числа
        String[] romanArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for(int i = 0; i < romanArray.length; i++ ){
            if (s.equals(romanArray[i])){
                return true;
            }
        }
        return false;
    }

    public static int toInt(String s) {  // преобразовать полученные значения в числа
        if (s.equals("1") || s.equals("I")) {
            return 1;
        } else if (s.equals("2") || s.equals("II")) {
            return 2;
        } else if (s.equals("3") || s.equals("III")) {
            return 3;
        } else if (s.equals("4") || s.equals("IV")) {
            return 4;
        } else if (s.equals("5") || s.equals("V")) {
            return 5;
        } else if (s.equals("6") || s.equals("VI")) {
            return 6;
        } else if (s.equals("7") || s.equals("VII")) {
            return 7;
        } else if (s.equals("8") || s.equals("VIII")) {
            return 8;
        } else if (s.equals("9") || s.equals("IX")) {
            return 9;
        } else if (s.equals("10") || s.equals("X")) {
            return 10;
        } else {
            throw new IllegalArgumentException("Неверный формат числа");
        }
    }

    public static int calculate(int a, int b, String znak) {
        if (znak.equals("+")) {
            return a + b;
        } else if (znak.equals("-")) {
            return a - b;
        } else if (znak.equals("*")) {
            return a * b;
        } else if (znak.equals("/")) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Неверный знак");
        }
    }
    public static String toRoman(int result) { //конвертация в римске числа
        String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanArray[result];
    }
}

