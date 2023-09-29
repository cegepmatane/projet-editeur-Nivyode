package controleur;

import architecture.Controleur;
import javafx.scene.control.ColorPicker;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.geometry.Point2D;
import modele.Assets;
import vue.VuePimpMyHero;

public class ControleurPimpMyHero extends Controleur {
	int NOMBRE_CHOIX = 3;

	private String itemChoisi ;
		
	

    public ControleurPimpMyHero() {
        Logger.logMsg(Logger.INFO, "new ControleurPimpMyHero()");
    }

    public void initialiser() {
        Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.initialiser()");
        VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CASQUE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CAPE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.ARMURE, "1");
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BOTTES, "1");
    }

	public Point2D getAssetPosition(Assets.ASSETS asset) {
		return Assets.getAssetPosition(asset);
	}

	public double getAssetSize(Assets.ASSETS asset) {
		return Assets.getAssetSize(asset);
	}

    public void notifierSelectionBouton(int idBouton) {
    	//List<String> boutons = VuePimpMyHero.getInstance().getBoutons();
    	Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.notifierBouton() - " + idBouton);
    	
    	switch(idBouton) {
    	case 0:
    		//#bouton-selection-casque
    		gererAffichageItem("casque");
    		break;
    	case 1:
    		//#bouton-selection-armure
    		gererAffichageItem("armure");
    		break;
    	case 2:
    		//#bouton-selection-cape
    		gererAffichageItem("cape");
    		break;
    	case 3:
    		//#bouton-selection-bottes
    		gererAffichageItem("bottes");
    		break;
    	case 4:
    		//#bouton-selection-animal
    		gererAffichageItem("animal");
    		break;
    	case 5:
    		//#bouton-selection-background
    		gererAffichageItem("background");
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
 
    private void gererAffichageItem(String typeItem) {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gererAffichageItem()");
    	itemChoisi = typeItem;
    	List<String> items = new ArrayList<String>();
    	
    	for (int i = 1; i <= NOMBRE_CHOIX;i++){
    		items.add(itemChoisi + i +".png");
		}
    	vue.VuePimpMyHero.getInstance().AfficherListe(itemChoisi, items);
    }

    
    
	public void notifierSelectionColorPicker(ColorPicker cp) {
		Logger.logMsg(Logger.INFO, "notifierSelectionColorPicker");
	}
}
