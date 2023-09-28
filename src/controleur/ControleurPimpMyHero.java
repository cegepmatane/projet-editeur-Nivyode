package controleur;

import architecture.Controleur;
import javafx.scene.control.ColorPicker;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.geometry.Point2D;
import modele.Assets;
import vue.VuePimpMyHero;

public class ControleurPimpMyHero extends Controleur {
	

    public ControleurPimpMyHero() {
        Logger.logMsg(Logger.INFO, "new ControleurPimpMyHero()");
    }

    public void initialiser() {
        Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.initialiser()");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BACKGROUND, "2");
        VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CASQUE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CAPE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.ARMURE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BOTTES, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.ANIMAL, "1");
    }

	public Point2D getAssetPosition(Assets.ASSETS asset) {
		return Assets.getAssetPosition(asset);
	}

	public double getAssetSize(Assets.ASSETS asset) {
		return Assets.getAssetSize(asset);
	}

    public void notifierSelectionBouton(int idBouton) {
    	List<String> boutons = VuePimpMyHero.getInstance().getBoutons();
    	Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.notifierBouton()");
    	switch(idBouton) {
    	case 0:
    		//#bouton-selection-casque
    		gerrerAffichageCasque();
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
    	case 6 :
    		//#bouton-telechargement
    		break;
    	case 7 :
    		//#bouton-refaire
    		break;
    	case 8 :
    		//#bouton-annuler
    		break;
    	default:
    		break;
    	}	
    }
	private void gerrerAffichageCasque() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageCasque()");
		List<String> casques = new ArrayList<String>();
		casques.add("casque1.png");
		casques.add("casque2.png");
		casques.add("casque3.png");
		vue.VuePimpMyHero.getInstance().AfficherListe("casque", casques);
		
		
    }
		
		// TODO Auto-generated method stub
	public void notifierSelectionColorPicker(ColorPicker cp) {
		// TODO Auto-generated method stub
		Logger.logMsg(Logger.INFO, "notifierSelectionColorPicker");
	}
}
