import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение");

        String input = sc.nextLine();

        CheckMistakes Check = new CheckMistakes();
        Check.setData(input);
    }
}