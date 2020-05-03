import java.io.IOException;

public class QuizGame {

    public static void main(String[] args) throws IOException {
        QuizModel theModel = new QuizModel();
        QuizView theView = new QuizView();
        QuizController theController = new QuizController(theModel, theView);

        theController.startGame();
    }
}
