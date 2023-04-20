import java.util.Scanner;

public class GameLogic {
    final String movie = new MovieRepo("movie-list.txt").getMovie();
    final private int movieLength = movie.length();
    private int numberOfGuesses;

    private String wrongLetters = "";
    private String gameHint = "";

    public GameLogic(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }


    private void addGameHint(int indexGuessedLetter, String inputGuessedLetter) {
        String tempGameHint = "";
        for (int i = 0; i < movieLength; i++) {
            if (indexGuessedLetter == i) {
                tempGameHint += inputGuessedLetter + " ";
            }
            else {
                tempGameHint += "_ ";
            }
        }
         gameHint = tempGameHint;
    }

    private void addWrongLetters(String letter) {
        wrongLetters += letter + " ";
    }


    public void start() {
        while (numberOfGuesses > 0) {
            System.out.println("You are guessing: " + gameHint.toString());
            System.out.println("You have guessed (" + numberOfGuesses + ") wrong letters: " + wrongLetters);
            System.out.print("Guess a letter: ");
            String inputGuess = new Scanner(System.in).nextLine();

            int indexInputGuess = movie.indexOf(inputGuess);
            if (indexInputGuess >= 0) {
                addGameHint(indexInputGuess, inputGuess);
            } else {
                addWrongLetters(inputGuess);
                numberOfGuesses--;
            }
        }
    }
}
