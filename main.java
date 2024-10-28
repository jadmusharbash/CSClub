import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recommender {
    public static void main(String[] args) {
        // List of movies
        List<String> movies = new ArrayList<>();
        movies.add("Inception");
        movies.add("The Matrix");
        movies.add("Interstellar");
        movies.add("The Dark Knight");
        movies.add("Avatar");

        // List of games
        List<String> games = new ArrayList<>();
        games.add("The Legend of Zelda");
        games.add("Minecraft");
        games.add("Fortnite");
        games.add("Call of Duty");
        games.add("Red Dead Redemption");

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for their preference
        System.out.println("What would you like a recommendation for? (1: Movie, 2: Game)");
        int choice = scanner.nextInt();

        // Recommend based on the user's choice
        if (choice == 1) {
            // Recommend a movie
            System.out.println("Here are some movie recommendations:");
            for (String movie : movies) { // Loop through the list of movies
                System.out.println("- " + movie);
            }
        } else if (choice == 2) {
            // Recommend a game
            System.out.println("Here are some game recommendations:");
            for (String game : games) { // Loop through the list of games
                System.out.println("- " + game);
            }
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}
