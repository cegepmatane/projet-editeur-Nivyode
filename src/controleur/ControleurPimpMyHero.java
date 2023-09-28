package controleur;

import architecture.Controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import modele.Assets;
import vue.VuePimpMyHero;

public class ControleurPimpMyHero extends Controleur {

    public ControleurPimpMyHero() {
        Logger.logMsg(Logger.INFO, "new ControleurPimpMyHero()");
    }

    public void initialiser() {
        Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.initialiser()");
        VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CASQUE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.ARMURE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CAPE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BOTTES, "1");
        //VuePimpMyHero.getInstance().supprimerAsset(Assets.ASSETS.TSHIRT);
    }

    public void notifierSelectionBouton(int idBouton) {
    	List<String> boutons = VuePimpMyHero.getInstance().getBoutons();
    	Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.notifierBouton()");
    	switch(idBouton) {
    	case 0:
    		//#bouton-selection-casque
    		break;
    	case 1:
    		//#bouton-selection-armure
    		break;
    	case 2:
    		//#bouton-selection-cape
    		break;
    	case 3:
    		//#bouton-selection-botte
    	case 4:
    		//#bouton-selection-animal
    		break;
    	case 5:
    		//#bouton-selection-background
    		break;
    	case 6:
    		//#bouton-texte-contour
    		break;
    	case 7 :
    		//#bouton-texte-lettre
    		break;
    	case 8 :
    		//#bouton-telechargement
    		break;
    	case 9 :
    		//#bouton-refaire
    		break;
    	case 10 :
    		//#bouton-annuler
    		break;
    	default:
    		break;
    	}	
    }
}
