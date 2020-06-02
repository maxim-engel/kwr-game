import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizModel {

    private final int MAX_PLAYERS = 4;
    private final int MIN_PLAYERS = 2;
    private final int INITIAL_SCORE = 150;
    private String state = "init";
    private List<String> playerNames = new ArrayList<>();
    private List<Integer> playerScore = new ArrayList<>();
    private List<String> chosenCategories = new ArrayList<>();
    private List<String> possibleCategories = new ArrayList<>();

    public QuizModel() {
        fillPossibleCategories();
    }

    private void fillPossibleCategories() {
        possibleCategories.add("Physik");
        possibleCategories.add("Informatik");
        possibleCategories.add("Klatsch und Tratsch");
        possibleCategories.add("Filme");
        possibleCategories.add("Geschichte");
    }

    public void prepareGame() {
        for (int i = 0; i < getAmountOfPlayers(); i++) {
            playerScore.add(INITIAL_SCORE);
        }
        Collections.shuffle(playerNames);
        setState("play");
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

        setState("player");
        return QuizGameRules;
    }

    public void insertPlayerName(String newName) {
        if (newName.equals("")) {
            if (playerNames.size() < MIN_PLAYERS) {
                setState("error");
            } else {
                setState("category");
            }
            return;
        }

        setPlayerName(newName);

        if (playerNames.size() >= MAX_PLAYERS) {
            setState("category");
        }
    }

    public void chooseCategory(int chosenIndex) {
        setChosenCategory(chosenIndex - 1);
        if (getChosenCategories().size() == getAmountOfPlayers()) {
            setState("build");
        }
    }

    public String getState() {
        return state;
    }

    private void setState(String newStatus) {
        this.state = newStatus;
    }

    private void setPlayerName(String newPlayerName) {
        this.playerNames.add(newPlayerName);
    }

    public String getPlayerName(int playerIndex) {
        return playerNames.get(playerIndex - 1);
    }

    public int getAmountOfPlayers() {
        return playerNames.size();
    }

    public int getMAX_PLAYERS() {
        return MAX_PLAYERS;
    }

    public int getMIN_PLAYERS() {
        return MIN_PLAYERS;
    }

    public List<String> getPossibleCategories() {
        return possibleCategories;
    }

    private void setChosenCategory(int categoryIndex) {
        this.chosenCategories.add(possibleCategories.remove(categoryIndex));
    }

    public List<String> getChosenCategories() {
        return chosenCategories;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<Integer> getPlayerScore() {
        return playerScore;
    }
}
