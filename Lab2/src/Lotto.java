import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        wyswietl(wprowadz());
    }

    public static ArrayList<Integer> number_base() {
        ArrayList<Integer> available_numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            available_numbers.add(i);
        }
        return available_numbers;
    }

    public static ArrayList<Integer> losuj() {
        ArrayList<Integer> winning_numbers = new ArrayList<Integer>();
        Random random = new Random();
        ArrayList<Integer> available_numbers = number_base();
        for (int i = 0; i < 6; i++) {
            int number_index = random.nextInt(available_numbers.size());
            winning_numbers.add(available_numbers.get(number_index));
            available_numbers.remove(number_index);
        }
        return winning_numbers;
    }

    public static void wyswietl(ArrayList<Integer> numbers) {
        System.out.println("oto numery: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> wprowadz() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> available_numbers = number_base();
        ArrayList<Integer> user_numbers = new ArrayList<Integer>();
        System.out.println("Wprowadz swoje numery: ");
        for (int i = 0; i < 6; i++) {
            System.out.printf("Numer %d: \n", i + 1);
            int numer = sc.nextInt();
            if(available_numbers.contains(numer)) {
                user_numbers.add(numer);
                available_numbers.remove(Integer.valueOf(numer));
            } else {
                i = i - 1;
                System.out.println("Wybierz numer od 1 do 49 jeszcze nie wybrany");
            }
        }
        return user_numbers;
    }
}


