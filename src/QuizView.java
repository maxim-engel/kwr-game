import java.util.List;

public class QuizView {

    public void showStartScreen(String gameTitle) {
        System.out.println(gameTitle);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        pressAnyKeyToContinue();
    }

    public void showGameRules(String[] gameRules) {
        for (String rule : gameRules) {
            System.out.printf("%s%n", rule);
        }

        pressAnyKeyToContinue();
    }

//    public String insertNames(boolean status) {
//        String name;
//        if(status = true) {
//            name = System.in.read();
//        }
//    }

    private void pressAnyKeyToContinue() {
        System.out.printf("%nDrücke beliebige Taste, um fortzufahren%n");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
