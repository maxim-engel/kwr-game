public class QuizController {

    private QuizModel theModel;
    private QuizView theView;

    public QuizController(QuizModel theModel, QuizView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    public void startGame() {

        theView.showStartScreen();
        theView.showGameRules(theModel.getQuizGameRules());

        theView.showInsertNameInstructions();
        while (theModel.getStatus().equals("player")) {
            theModel.insertPlayerName(theView.insertName());

            if (theModel.getStatus().equals("error")) {
                theView.showPlayerCapNotReached();
                System.exit(0);
            }

            if (theModel.getStatus().equals("player") || theModel.getAmountOfPlayers() == 4) {
                theView.showPlayerName(theModel.getAmountOfPlayers(), theModel.getPlayerName(theModel.getAmountOfPlayers()));
            }
        }

        theView.showChooseCategoriesInstruction();
        while (theModel.getStatus().equals("category")) {
            theModel.chooseCategory(theView.showPossibleCategoriesAndChoose(theModel.getPossibleCategories(),
                    theModel.getAmountOfPlayers() - theModel.getChosenCategories().size()));
        }
        theView.showChosenCategories(theModel.getChosenCategories());

        theView.showQuizIsBuilding();
        theModel.randomizePlayerOrder();
        theModel.fillInitialScore();
        theView.showPlayerOrderWithPoints(theModel.getPlayerNames(), theModel.getPlayerScore());
    }


}
