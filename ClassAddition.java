import java.util.ArrayList;
public class ClassAddition {
    public String dataTwo;

    public void newAddition (String dataAddition){
        dataTwo = dataAddition;


        // Проверка на корректность написания.
        String[] check = dataTwo.split("\\s*\\+\\s*");
        char[] checkOperandOne = check[0].toCharArray();
        char[] checkOperandTwo = check[1].toCharArray();

        if (check.length != 2){
            System.out.println("Операндов должно быть 2.");
            return;
        }

        if (checkOperandOne[0] != '"'){
            System.out.println("Первый операнд должен начинаться с двойных кавычек.");
            return;
        }

        if (checkOperandOne[checkOperandOne.length-1]!='"'){
            System.out.println("Первый операнд должен заканчиваться двойными кавычками.");
            return;
        }

        if (checkOperandTwo[0] != '"') {
            System.out.println("Второй операнд должен начинаться с двойных кавычек.");
            return;
        }
        if (checkOperandTwo[checkOperandTwo.length -1] != '"'){
            System.out.println("Воторой операнд должен заканчиваться двойными кавычками.");
            return;
        }

        // Проверка на количество кавычек в операндах.
        int countOne = 0;
        for (char j : checkOperandOne){
            if (j == '"'){
                countOne++;
            }
            if (countOne>2){
                System.out.println("Кавычки, в первом операнде, должны быть только в начале и в конце операнда (по 2 на операнд).");
                return;
            }
        }

        int countTwo = 0;
        for (char j : checkOperandTwo){
            if (j == '"'){
                countTwo++;
            }
            if (countTwo>2){
                System.out.println("Кавычки, во втором операнде, должны быть только в начале и в конце операнда (по 2 на операнд).");
                return;
            }
        }

        if (checkOperandOne.length<3 || checkOperandOne.length>12){
            System.out.println("Первый операнд должен быть в диапозоне от 1 до 10 символов (не учитывая кавычек).");
            return;
        }
        if (checkOperandTwo.length<3 || checkOperandTwo.length>12){
            System.out.println("Второй операнд должен быть в диапозоне от 1 до 10 символов (не учитывая кавычек).");
            return;
        }

System.exit(0);
        // Решение.

        ArrayList<Character> result = new ArrayList<>();
        for (int i=0; i<checkOperandOne.length-1; i++){
            result.add(checkOperandOne[i]);
        }
        for (int i=1; i<checkOperandTwo.length; i++){
            result.add(result.size(), checkOperandTwo[i]);
        }

        StringBuilder resultString = new StringBuilder(10);

        for (char j : result){
            resultString.append(j);
        }
        System.out.println(resultString);
    }
}


