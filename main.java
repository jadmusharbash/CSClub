import java.util.*;

public class Recommender {
    public static void main(String[] args) {
        // Game recommendations categorized by genres with prices and compatibility
        Map<String, List<Game>> games = new HashMap<>();
        games.put("Adventure", Arrays.asList(
                new Game("The Legend of Zelda", 60, "Console"),
                new Game("Red Dead Redemption", 40, "PC/Console")
        ));
        games.put("Sandbox", Arrays.asList(
                new Game("Minecraft", 30, "PC/Phone/Console"),
                new Game("Terraria", 10, "PC/Phone/Console")
        ));
        games.put("Battle Royale", Arrays.asList(
                new Game("Fortnite", 0, "PC/Phone/Console"),
                new Game("Apex Legends", 0, "PC/Console")
        ));

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Main prompt
        while (true) {
            System.out.println("Would you like a recommendation for a Game? (Enter 'Game' or 'Quit' to exit)");
            choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("game")) {
                // Ask for price range
                System.out.println("What is your maximum budget? (Enter a number in dollars)");
                int maxPrice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Ask for compatibility preference
                System.out.println("Which platform are you looking for? (PC, Console, Phone, or All)");
                String compatibility = scanner.nextLine().trim().toLowerCase();

                // Filter and recommend games
                System.out.println("Here are some games that match your preferences:");
                boolean found = false;

                for (String genre : games.keySet()) {
                    for (Game game : games.get(genre)) {
                        if (game.price <= maxPrice &&
                                (compatibility.equals("all") || game.compatibility.toLowerCase().contains(compatibility))) {
                            System.out.println("- " + game.name + " ($" + game.price + ", " + game.compatibility + ")");
                            found = true;
                        }
                    }
                }

                if (!found) {
                    System.out.println("No games match your preferences. Try increasing your budget or selecting a different platform.");
                }
            } else if (choice.equals("quit")) {
                System.out.println("Thank you for using the Recommender!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'Game' or 'Quit'.");
            }
        }
    }
}

// Game class to store game details
class Game {
    String name;
    int price;
    String compatibility;

    public Game(String name, int price, String compatibility) {
        this.name = name;
        this.price = price;
        this.compatibility = compatibility;
    }
}
