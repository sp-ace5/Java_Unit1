import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GuessingGame {
    public GuessingGame() {
        System.out.println("Grrr, What is your name?");
        System.out.println("(type in your name NOW) ");

        Scanner input = new Scanner(System.in);

        String name = input.nextLine();

        System.out.println(name + "Can you guess my number between 1-100?");

        Random rand = new Random();
        int number = rand.nextInt(100);
        int tries = 0;

        while (true) {
            int guess;
            try {
                guess = input.nextInt();
            } catch (InputMismatchException e) {
                String bad_input = input.next();
                System.out.println("That's not an number");
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println(guess + " is not a valid number, try again");
                continue;
            }

            tries = tries + 1;

            if (guess < number) {
                System.out.println("Your guess is too low!");
            } else if (guess > number) {
                System.out.println("Your guess is too high!");
            } else {
                System.out.println("You got lucky, " + name);
                System.out.println("It took you " + tries + " guesses!");
                break;
            }
        }
    }
}