import java.util.ArrayList;
public class ClassMultiplication {
    public String dataFour;

    public void newMultiplication (String dataMultiplication){
        dataFour = dataMultiplication;

        // Проверка на корректность написания.
        String[] check = dataFour.split("\\s*\\*\\s*");
        char[] checkOperandOne = check[0].toCharArray();
        char[] checkOperandTwo = check[1].toCharArray();
        String operandTwo1 = String.valueOf(checkOperandTwo);

        try {
            if (check.length != 2) throw new Exception("Операндов должно быть 2.");
        }catch (Exception eex){
            System.out.println(eex.getMessage());
            return;
        }
        try {
            if (checkOperandOne[0] != '"') throw new Exception("Первый операнд должен начинаться с кавычек.");
        }catch (Exception tgg){
            System.out.println(tgg.getMessage());
            return;
        }
        try {
            if (checkOperandOne[checkOperandOne.length-1]!='"') throw new Exception("Первый операнд должен заканчиваться двойными кавычками.");
        }catch (Exception exxxx){
            System.out.println(exxxx.getMessage());
            return;
        }


        // Проверка второго операнда на коррекнтность ввода.
        String[] numbers = {"1","2","3","4","5","6","7","8","9","10"};
        int Check = 0;

        for (String j : numbers){
            if (operandTwo1.equals(j)){
                Check++;
            }
        }

        try {
            if (Check !=1 ) throw new Exception("Второй операнд должен быть в формате от 1 - 10 без кавычек.");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }

        // Проверка на количество кавычек в операндах.
        int countOne = 0;
        for (char j : checkOperandOne){
            if (j == '"'){
                countOne++;
            }
            try{
                if (countOne>2) throw new Exception("Кавычки, в первом операнде, должны быть только в начале и в конце операнда(по 2 на операнд)");
            }catch (Exception eexxx){
                System.out.println(eexxx.getMessage());
                return;
            }
        }

        try {
            if (checkOperandOne.length<3 || checkOperandOne.length>12) throw new Exception("Первый операнд должен быть в диапозоне от 1 до 10 символов (не учитывая кавычек)");
        }catch (Exception eexxxxe) {
                System.out.println(eexxxxe.getMessage());
                return;
        }

        // Решение.

        String operandTwoTime = "0";                                                                    // Преобразую второй операнд в значение типа int.
        for (String j : numbers){
            if(operandTwo1.contains(j)){
                operandTwoTime = j;
            }
        }

        int operandTwo = Integer.parseInt(operandTwoTime);
        char[] operandOneTime = new char[checkOperandOne.length-2];

        for (int i=1; i<checkOperandOne.length-1; i++){                                                 // Убираю кавычки у первого операнда.
             operandOneTime[i-1] = checkOperandOne[i];
        }

        String operandOneNotQuotationMark = String.valueOf(operandOneTime);                             // Присваюиваю имя первому операнду.

        ArrayList <String> result = new ArrayList<>();                                                  // Записываю результат в массив.
        for (int i=0; i < operandTwo; i++){
            result.add(operandOneNotQuotationMark);
        }

        result.add(0,"\"");                                                                 // Добавляю кавычки в начало и конец массива.
        result.add("\"");

        StringBuilder resultString = new StringBuilder();

        for (String j : result){                                                                         // Обыгрываю ситуацию, если результат умножения
            for (char k : j.toCharArray()){                                                              //   будет длиннее 40 символов.
                if (resultString.length()<40){
                    resultString.append(k);
                }else{
                    break;
                }
            }
        }

        if (resultString.length() >=40){                                                                  // Вывожу результат.
            System.out.println(resultString + "..." + "\"");
        }else{
            System.out.println(resultString);
        }
    }
}
