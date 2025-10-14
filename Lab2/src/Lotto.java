import java.util.Random;
import java.util.ArrayList;

public class Lotto {
    public static void main(String[] args) {
        wyswietl(losuj());
    }

    public static ArrayList<Integer> losuj() {
        ArrayList<Integer> winning_numbers = new ArrayList<Integer>();
        Random random = new Random();
        ArrayList<Integer> available_numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            available_numbers.add(i);
        }
        for (int i = 0; i < 6; i++) {
            int number_index = random.nextInt(available_numbers.size());
            winning_numbers.add(available_numbers.get(number_index));
            available_numbers.remove(number_index);
        }
        return winning_numbers;
    }

    public static void wyswietl(ArrayList<Integer> numbers) {
        System.out.println("oto zwycięskie numery: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }
}


