package controleur;

import architecture.Controleur;
import com.sun.media.jfxmedia.logging.Logger;
import modele.Assets;
import vue.VuePimpMyHero;

public class ControleurPimpMyHero extends Controleur {

    public ControleurPimpMyHero() {
        Logger.logMsg(Logger.INFO, "new ControleurPimpMyHero()");
    }

    public void initialiser() {
        Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.initialiser()");
        VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.TSHIRT, "1");
        //VuePimpMyHero.getInstance().supprimerAsset(Assets.ASSETS.TSHIRT);
    }

    public void notifierSelectionCheveux() {
    }
}
