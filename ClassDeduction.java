import java.util.ArrayList;
import java.util.regex.*;
public class ClassDeduction {
    public String dataThree;

    public void newDeduction (String dataDeduction){
        dataThree = dataDeduction;

        // Регулярное выражение для проверки выражения на правильность ввода и определение операндов.
        Pattern pattern = Pattern.compile("(\"[^0-9]*\")\\s*-\\s*(\"[^0-9]*\")");
        Matcher matcher = pattern.matcher(dataThree);

        if (!matcher.find()){
            System.out.println("Ваше выражение не соответсвует параметрам ввода.");
            return;
        }

        String[] check = {matcher.group(1), matcher.group(2)};

        char[] checkOperandOne = check[0].toCharArray();
        char[] checkOperandTwo = check[1].toCharArray();

        // Проверка на длину операндов.
        if (checkOperandOne.length<3 || checkOperandOne.length>12){
            System.out.println("Первый операнд должен быть в диапозоне от 1 до 10 символов (не учитывая кавычек).");
            return;
        }
        if (checkOperandTwo.length<3 || checkOperandTwo.length>12){
            System.out.println("Второй операнд должен быть в диапозоне от 1 до 10 символов (не учитывая кавычек).");
            return;
        }

        // Проверка на наличие пробелов в зоне между кавычкой и буквой.
        if (checkOperandOne[1] == ' '){
            System.out.println("Не рекомендуется, в первом операнде, между кавычкой и буквой ставить пробел.");
            return;
        }
        if (checkOperandOne[checkOperandOne.length-2] == ' '){
            System.out.println("Не рекомендуется, в первом операнде, между кавычкой и буквой ставить пробел.");
            return;
        }
        if (checkOperandTwo[0] == ' '){
            System.out.println("Не рекомендуется, во втором операнде, между кавычкой и буквой ставить пробел.");
            return;
        }
        if (checkOperandTwo[checkOperandTwo.length-2] == ' '){
            System.out.println("Не рекомендуется, во втором операнде, между кавычкой и буквой ставить пробел.");
            return;
        }

        // Определние операндов для решения.
                                                                                               // Убираю кавычки у второго операнда, чтобы они не мешали в ходе проверки.
        char[] arrayOperandTwoNotQuotationMark = new char[checkOperandTwo.length-2];
        for (int i=1; i<checkOperandTwo.length-1; i++){
            arrayOperandTwoNotQuotationMark[i-1] = checkOperandTwo[i];
        }

        String operandTwoNotQuotationMark = new String(arrayOperandTwoNotQuotationMark);       // "Присваеваю имя" второму операнду без кавычек.

        char[] arrayOperandOneNotQuotationMark = new char[checkOperandOne.length-2];           // Убираю кавычки у первого операнда.
        for (int i=1; i<checkOperandOne.length-1; i++) {
            arrayOperandOneNotQuotationMark[i - 1] = checkOperandOne[i];
        }

        String operandOneNotQuotationMark = new String(arrayOperandOneNotQuotationMark);       // "Присваиваю имя" первому операнду без кавычек.


        String[] operandOneSplit = operandOneNotQuotationMark.split(" ");                // Провожу проверку на присутствие пробела в первом операнде.
        ArrayList <String> result = new ArrayList<>();
        boolean foundCoincidences = false;
        boolean foundCoincidencesTwo = false;


        if (operandOneSplit.length >2){
            System.out.println("Ограничение в два слогаемых в первом операнде.");
            return;
        }

        // Решение.

        if (operandOneSplit.length>1) {                                                             // Выясняю есть ли совпадения при налчии пробелов в первом операнде.
            for (String j : operandOneSplit) {
                if (operandTwoNotQuotationMark.contains(j)) {
                    foundCoincidences = true;
                    break;
                }
            }

            if (!foundCoincidences) {                                                                // Решение, если совпадений найдено не было.
                System.out.println(check[0]);
                return;
            } else {
                for (String j : operandOneSplit) {
                    if (!(operandTwoNotQuotationMark.contains(j))) {
                        result.add(j);
                    }
                }

                result.add(0, "\"");                                                    // Если совпадение было, заполняем массив и выводим результат.
                result.add("\"");
                for (String s : result) {
                    System.out.print(s);
                }
            }
        }

        if (operandOneSplit.length<2) {                                                             // Решение, если пробелов в первом операнде не было.
            if (operandOneNotQuotationMark.contains(operandTwoNotQuotationMark)){
                foundCoincidencesTwo = true;
            } else {
                System.out.println(check[0]);                                                       // Вывожу результат, если  совпадений не было.
            }
            if (foundCoincidencesTwo) {
                System.out.println("\"" + "\"");                                                    // Вывожу результат, если совпадение было.
            }
        }
    }
}
