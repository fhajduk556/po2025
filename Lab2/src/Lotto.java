import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        ArrayList<Integer> wining_numbers = losuj();
        ArrayList<Integer> user_numbers = makeArray(args);
        if (user_numbers == null) {
            user_numbers = wprowadz();
        }
        System.out.println("trafień: " + String.valueOf(liczba_trafien(user_numbers,  wining_numbers)));
        wyswietl(wining_numbers);
        long t_start = System.currentTimeMillis();
        int counter = 0;
        while (liczba_trafien(user_numbers, wining_numbers) != 6) {
            user_numbers = losuj();
            counter++;
        }
        long t_stop = System.currentTimeMillis();
        long czas = t_stop - t_start;
        System.out.println("losowań: " + String.valueOf(counter));
        System.out.println("czas: " + String.valueOf(czas));
        return;
    }

    public static ArrayList<Integer> makeArray(String[] args) {
        if (args.length != 6) {
            return null;
        }
        ArrayList<Integer> user_numbers = new ArrayList<>();
        ArrayList<Integer> available_numbers = number_base();
        for (int i = 0; i < 6; i++) {
            try{
                int numer = Integer.parseInt(args[i]);
                if (available_numbers.contains(numer)) {
                    user_numbers.add(numer);
                    available_numbers.remove(Integer.valueOf(numer));
                } else {
                    return null;
                }
            }catch(NumberFormatException e){
                return null;
            }
        }
        return user_numbers;
    }

    public static ArrayList<Integer> number_base() {
        ArrayList<Integer> available_numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            available_numbers.add(i);
        }
        return available_numbers;
    }

    public static ArrayList<Integer> losuj() {
        ArrayList<Integer> ran_numbers = new ArrayList<Integer>();
        Random random = new Random();
        ArrayList<Integer> available_numbers = number_base();
        for (int i = 0; i < 6; i++) {
            int number_index = random.nextInt(available_numbers.size());
            ran_numbers.add(available_numbers.get(number_index));
            available_numbers.remove(number_index);
        }
        return ran_numbers;
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
    public static int liczba_trafien(ArrayList<Integer> numbers, ArrayList<Integer> winning_numbers) {
        ArrayList<Integer> numbers_copy = new ArrayList<>(numbers);
        numbers_copy.retainAll(winning_numbers);
        return numbers_copy.size();
    }
}


