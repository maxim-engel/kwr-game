import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizController {

    private QuizModel theModel;
    private QuizView theView;

    public QuizController(QuizModel theModel, QuizView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    public void startGame() {
        theView.showStartScreen(theModel.getGameTitle());
        theView.showGameRules(theModel.getQuizGameRules());

    }


}
