public class QuizController {

    private QuizModel theModel;
    private QuizView theView;

    public QuizController(QuizModel theModel, QuizView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    public void startGame() {
        while (!theModel.getState().equals("play")) {
            switch (theModel.getState()) {
                case "error":
                    executeError();
                    break;
                case "init":
                    executeInit();
                    break;
                case "player":
                    executePlayer();
                    break;
                case "category":
                    executeCategory();
                    break;
                case "build":
                    executeBuild();
                    break;
            }
        }
    }

    private void executeInit() {
        theView.showStartScreen();
        theView.showGameRules(theModel.getQuizGameRules());
    }

    private void executeError() {
        theView.showPlayerCapNotReached();
        System.exit(0);
    }

    private void executePlayer() {
        theView.showInsertNameInstructions();
        theModel.insertPlayerName(theView.insertName());
        theView.showPlayerName(theModel.getAmountOfPlayers(), theModel.getPlayerName(theModel.getAmountOfPlayers()));
    }

    private void executeCategory() {
        theView.showChooseCategoriesInstruction();
        theModel.chooseCategory(theView.showPossibleCategoriesAndChoose(theModel.getPossibleCategories(),
                theModel.getAmountOfPlayers() - theModel.getChosenCategories().size()));
    }

    private void executeBuild() {
        theView.showChosenCategories(theModel.getChosenCategories());
        theView.showQuizIsBuilding();
        theModel.prepareGame();
        theView.showPlayerOrderWithPoints(theModel.getPlayerNames(), theModel.getPlayerScore());
    }
}
