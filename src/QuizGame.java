public class QuizGame {

    public static void main(String[] args) {

        QuizModel theModel = new QuizModel();
        QuizView theView = new QuizView();
        QuizController theController = new QuizController(theModel, theView);

        theController.startGame();

    }
}
