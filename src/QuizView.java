import java.util.List;
import java.util.Scanner;

public class QuizView {

    Scanner scanner = new Scanner(System.in);

    public void showStartScreen() {
        System.out.println("+---------------------------------+");
        System.out.println("|---> WEISS ETWAS UND GEWINN! <---|");
        System.out.println("+---------------------------------+");

        pressAnyKeyToContinue("Spiel zu starten");
    }

    public void showGameRules(String[] gameRules) {
        System.out.println("REGELWERK:");
        for (String rule : gameRules) {
            System.out.printf("%s%n", rule);
        }

        pressAnyKeyToContinue("fortzufahren");
    }

    public void showInsertNameInstructions() {
        System.out.println("SPIELER NAMEN:");
        System.out.println("Gebe die Spielernamen ein oder bestätige mit ENTER ohne Eingabe, um das Spiel zu starten!");
    }

    public String insertNames() {
        System.out.printf("Name Eingeben: ");
        return scanner.nextLine();
    }

    public void showChooseCategoriesInstruction() {
        System.out.println("WISSENKATEGORIE WÄHLEN:");
        System.out.println("Entscheidet euch für die Kategorien, indem ihr die Ziffer vorgebt!");
    }

    public int showPossibleCategoriesAndChoose(List<String> categoryList, int amount) {
        int index = 1;
        System.out.printf("Folgende Kategorien sind möglich (%d könnt ihr wählen):%n", amount);
        for (String category : categoryList) {
            System.out.printf("%d - %s%n", index, category);
            index++;
        }

        System.out.println("Welche Kategorie soll es sein: ");
        return scanner.nextInt();
    }

    public void showChosenCategories(List<String> categoryList) {
        System.out.println("Spiel startet mit folgenden Wissenkategorien:");
        for (String category : categoryList) {
            System.out.println(category);
        }
    }

    public void showPlayerName(int playerNumber, String playerName) {
        System.out.printf("%d. Spieler: %s%n", playerNumber, playerName);
    }

    public void showPlayerCapNotReached() {
        System.out.println("Leider nicht genug Spieler für eine Runde!");
    }

    public void showQuizIsBuilding() {
        System.out.println("Kreuzworträtsel wird aufgebaut...");
    }

    public void showPlayerOrderWithPoints(List<String> playerNames, List<Integer> playerPoints) {
        System.out.println("Zufällige Reihenfolge wurde ermittelt und Startpunkte wurden vergeben!");

        for (int i = 0; i < playerNames.size(); i++) {
            System.out.printf("%s - %d Punkte%n", playerNames.get(i), playerPoints.get(i));
        }
    }

    private void pressAnyKeyToContinue(String reason) {
        System.out.printf("%nDrücke beliebige Taste, um %s...%n", reason);
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
