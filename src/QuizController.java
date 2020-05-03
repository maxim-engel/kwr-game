import java.io.IOException;

public class QuizController {

    private QuizModel theModel;
    private QuizView theView;

    public QuizController(QuizModel theModel, QuizView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    public void startGame() throws IOException {

        theView.showStartScreen();
        theView.showGameRules(theModel.getQuizGameRules());
        insertPlayerNames();
        chooseCategory();
        theView.showQuizIsBuilding();
        theModel.randomizePlayerOrder();
        theModel.fillInitialScore();
        theView.showPlayerOrderWithPoints(theModel.getPlayerNames(),theModel.getPlayerScore());
    }

    private void insertPlayerNames() {
        String newName;
        theView.showInsertNameInstructions();

        for (int i = 0; i < theModel.getMAX_PLAYERS(); i++) {
            newName = theView.insertNames();

            if (newName.equals("")) break;

            theView.showPlayerName(i + 1, newName);
            theModel.setPlayerName(newName);
        }

        if (theModel.getAmountOfPlayers() < theModel.getMIN_PLAYERS()) {
            theView.showPlayerCapNotReached();
            System.exit(0);
        }
    }

    private void chooseCategory() {
        int chosenIndex;
        int amountOfCategories = theModel.getAmountOfPlayers();
        theView.showChooseCategoriesInstruction();

        while (amountOfCategories > 0) {
            chosenIndex = theView.showPossibleCategoriesAndChoose(theModel.getPossibleCategories(), amountOfCategories);
            theModel.setChosenCategory(chosenIndex - 1);
            amountOfCategories--;
        }

        theView.showChosenCategories(theModel.getChosenCategories());

    }
}
