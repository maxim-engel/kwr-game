import java.util.Collections;
import java.util.List;

public class QuizModel {

    private String gameTitle = "Weiß etwas und gewinn!";
    private List<String> playerNames;
    private List<String> chosenCategories;

    private List<String> possibleCategories;

    private void fillPossibleCategories() {
        possibleCategories.add("Physik");
        possibleCategories.add("Informatik");
        possibleCategories.add("Klatsch und Tratsch");
        possibleCategories.add("Filme");
        possibleCategories.add("Geschichte");
    }

    public void startNewGame() {
        fillPossibleCategories();
    }

    public String[] getQuizGameRules() {
        String[] QuizGameRules = new String[8];
        QuizGameRules[0] = "1. Jeder Spieler wählt 2 Kategorien, wobei jede Kategorie 2 Fragen pro Spieler hat. Dies ist die Basis des Kreuzworträtsels.";
        QuizGameRules[1] = "2. Die Spielzüge der Spieler werden nach dem Zufallsprinzip ausgewählt.";
        QuizGameRules[2] = "3. In jedem Zug wählt ein Spieler eine Frage und hat 2 Minuten Zeit, diese zu beantworten. (Bitte schreibe nur die Nummer der Frage)";
        QuizGameRules[3] = "4. Jeder Spieler beginnt mit xx Münzen, mit denen Zeit (5s, 10s, 15s) oder ein Hinweis in Form eines Buchstabens gekauft werden kann.";
        QuizGameRules[4] = "5. Ein Spieler kann Dinge kaufen, solange er genügend Münzen hat.";
        QuizGameRules[5] = "6. Jede richtige Antwort bringt xx Punkte und xx Münzen.";
        QuizGameRules[6] = "7. Ein Spieler kann entweder eine neue Frage auswählen oder das Wort eines anderen Spielers korrigieren.";
        QuizGameRules[7] = "8. Nach Beendigung des Kreuzworträtsels endet das Spiel und der Spieler mit der höchsten Punktzahl gewinnt.";

        return QuizGameRules;
    }

    public int setPlayerName(String newPlayerName) {
        playerNames.add(newPlayerName);
        return playerNames.size();
    }

    public String getPlayerName(int playerIndex) {
        return playerNames.get(playerIndex);
    }

    public int getAmountOfPlayers() {
        return playerNames.size();
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public List<String> getPossibleCategories() {
        return possibleCategories;
    }

    public int setChosenCategory(int categoryIndex) {
        chosenCategories.add(possibleCategories.get(categoryIndex));
        return chosenCategories.size();
    }

    public void radomizePlayerOrder() {
        Collections.shuffle(playerNames);
    }
}
