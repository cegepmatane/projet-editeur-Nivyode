package vue;

import architecture.Vue;
import com.sun.media.jfxmedia.logging.Logger;
import controleur.ControleurPimpMyHero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VuePimpMyHero extends Vue {

    protected ControleurPimpMyHero controleur;

    protected static VuePimpMyHero instance = null;

    public static VuePimpMyHero getInstance() {
        if(null==instance)instance = new VuePimpMyHero();
        return VuePimpMyHero.instance;
    };

    private VuePimpMyHero()
    {
        super("personage.fxml", VuePimpMyHero.class, 1294,743);
        super.controleur = this.controleur = new ControleurPimpMyHero();
        Logger.logMsg(Logger.INFO, "new VuePimpMyHero()");
    }

    public void activerControles() {
        super.activerControles();

        /*
        Button selectionnerCheveux = (Button) lookup("#selectionner-cheveux");
        selectionnerCheveux.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Logger.logMsg(Logger.INFO, "Bouton Choisir Cheveux activé");
                controleur.notifierSelectionCheveux();
            }
        });

         */
    }
}
