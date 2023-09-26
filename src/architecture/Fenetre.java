package architecture;

import javafx.application.Platform;
import javafx.stage.Stage;

public class Fenetre extends Navigateur {
    public void start(Stage stade) {
        this.stade = stade;
        stade.setScene(Controleur.selectionnerVuePrincipale());
        stade.show();

        Platform.runLater(() -> {
            Controleur.selectionnerVuePrincipale().getControleur().initialiser();
        });
    }
}
