import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckMistakes{
    public String data;

    public void setData (String newData) {

        data = newData;

        // Проверка на пустоту строки.
        try{
            if (data.isEmpty()) throw new Exception("Строка не должна быть пустой");
        }catch (Exception exepty){
            System.out.println(exepty.getMessage());
            return;
        }


        // Проверка на коррекность ввода.

        Pattern pattern = Pattern.compile("^[!+\\-*/\"A-Za-z0-9\\s]*$");
        Matcher matcher = pattern.matcher(data);

        try {
            if (!matcher.matches()) throw new Exception("Ваше выражение не соотвествует параметрам ввода (в выражении присутвуют посторонние символы).");
        }catch (Exception exx){
            System.out.println(exx.getMessage());
            return;
        }

        // Выбор дальнейших действия в зависимости от знака арифметики.
        int checkOperators = 0;

        if (data.indexOf('+')>1){
            checkOperators++;
            String dataAddition = data;
            ClassAddition Addition = new ClassAddition();
            Addition.newAddition(dataAddition);
        }else{

            if (data.indexOf('-')>1) {
                checkOperators++;
                String dataDeduction = data;
                ClassDeduction Deduction = new ClassDeduction();
                Deduction.newDeduction(dataDeduction);
            }else{

                if (data.indexOf('*')>1){
                    checkOperators++;
                    String dataMultiplication = data;
                    ClassMultiplication Multiplication = new ClassMultiplication();
                    Multiplication.newMultiplication(dataMultiplication);
                }else{

                    if (data.indexOf('/')>1){
                        checkOperators++;
                        String dataDivision = data;
                        ClassDivision Division = new ClassDivision();
                        Division.newDivision(dataDivision);
                    }
                }
            }
        }
        try {
            if (checkOperators < 1) throw new Exception("В выражении отсуствует оператор.");
        }catch (Exception exxe){
            System.out.println(exxe.getMessage());
        }
    }
}
