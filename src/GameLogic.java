import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GameLogic {
    final String movie = new MovieRepo("movie-list.txt").getMovie();
    final private int movieLength = movie.length();
    private int numberOfGuesses;
    private String wrongLetters = "";
    private List<String> gameHint = new ArrayList<String>();

    public GameLogic(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
        for (int i = 0; i < movieLength; i++) {
            if (movie.charAt(i) == ' ') {
                gameHint.add(" ");
            } else {
                gameHint.add("_");
            }
        }
    }

    private void addGameHint(String inputGuessedLetter) {
        for (int i = 0; i < movieLength; i++) {

            if (movie.charAt(i) == inputGuessedLetter.charAt(0)) {
                gameHint.set(i, inputGuessedLetter);
            }
        }
    }

    private String printGameHint() {
        StringBuilder tempValue = new StringBuilder();
        for (int i = 0; i < movieLength; i++) {
            tempValue.append(gameHint.get(i));
        }
        return  tempValue.toString();
    }

    private void addWrongLetters(String letter) {
        if (!wrongLetters.contains(letter)) {
            wrongLetters += letter + " ";
        }
    }

    private boolean detectWinner() {
        return !movie.equals(printGameHint());
    }

    public void start() {
        while (numberOfGuesses > 0 && detectWinner()) {
            System.out.println("You are guessing: " + printGameHint());
            System.out.println("You have guessed (" + numberOfGuesses + ") wrong letters: " + wrongLetters);
            System.out.print("Guess a letter: ");
            String inputGuess = new Scanner(System.in).nextLine();

            int indexInputGuess = movie.indexOf(inputGuess);
            if (indexInputGuess >= 0) {
                addGameHint(inputGuess);
            } else {
                addWrongLetters(inputGuess);
                numberOfGuesses--;
            }
        }
        if(detectWinner()) {
            System.out.println("You run out of guesses. The movie is " + movie);
        } else {
            System.out.println("You guessed the movie! The movie is " + movie);
        }
    }
}
