import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;


public class MovieRepo {
    final private String fileName;
    final private Random random = new SecureRandom();


    public MovieRepo(String fileName) {
        this.fileName = fileName;
    }

    private Scanner createScanner()  {
        try {
            return new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int getMovieCount() {
        int count = 0;

        Scanner scanner = createScanner();

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        scanner.close();
        return count;
    }

    public String getMovie() {

        Scanner scanner = createScanner();

        int movieIndex = random.nextInt(0, getMovieCount());

        for (int i = 0; i < movieIndex; i++) {
            scanner.nextLine();
        }

        String movie = scanner.nextLine();
        scanner.close();
        return movie;
    }
}
