import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("How many guesses do you want? ");
        int numberOfGuesses = input.nextInt();

        GameLogic game = new GameLogic(numberOfGuesses);
        game.start();
    }
}