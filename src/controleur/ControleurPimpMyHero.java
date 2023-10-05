package controleur;

import architecture.Controleur;
import javafx.scene.control.ColorPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.geometry.Point2D;
import modele.Assets;
import vue.VuePimpMyHero;

public class ControleurPimpMyHero extends Controleur {
	final int NOMBRE_CHOIX = 5;

	private Assets.ASSETS typeChoisi ;
		

    public ControleurPimpMyHero() {
        Logger.logMsg(Logger.INFO, "new ControleurPimpMyHero()");
    }

    public void initialiser() {
        Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.initialiser()");
        VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CASQUE, 1);
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.ARMURE, 1);
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.CAPE, 1);
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BOTTES, 1);
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.ANIMAL, 1);
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BACKGROUND, 2);
		//changerBackgroundAleatoire();
    }

	public void changerBackgroundAleatoire() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.changerBackgroundAleatoire()");
		int random = (int)(Math.random() * 5 + 1);
		VuePimpMyHero.getInstance().changerAsset(Assets.ASSETS.BACKGROUND,random);
		// Schedule the task to run in 3 seconds
		Timer timer = new Timer();
		timer.schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				changerBackgroundAleatoire();
			}
		}, 3000);
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
    		gererAffichageItem(Assets.ASSETS.CASQUE);
    		break;
    	case 1:
    		//#bouton-selection-armure
    		gererAffichageItem(Assets.ASSETS.ARMURE);
    		break;
    	case 2:
    		//#bouton-selection-cape
    		gererAffichageItem(Assets.ASSETS.CAPE);
    		break;
    	case 3:
    		//#bouton-selection-bottes
    		gererAffichageItem(Assets.ASSETS.BOTTES);
    		break;
    	case 4:
    		//#bouton-selection-animal
    		gererAffichageItem(Assets.ASSETS.ANIMAL);
    		break;
    	case 5:
    		//#bouton-selection-background
    		gererAffichageItem(Assets.ASSETS.BACKGROUND);
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
    	case 9 :
    		//#bouton-choix-1
    		changerItemChoisi(typeChoisi,1);
    		break;
    	case 10:
    		//#bouton-choix-2
    		changerItemChoisi(typeChoisi,2);
    		break;
    	case 11:
    		//bouton-choix-3
    		changerItemChoisi(typeChoisi,3);
    		break;
    	case 12:
    		//bouton-choix-4
    		changerItemChoisi(typeChoisi,4);
    		break;
    	case 13:
    		//bouton-choix-5
    		changerItemChoisi(typeChoisi,5);
    		break;
    	default:
    		break;
    	}	
    }
 
    private void gererAffichageItem(Assets.ASSETS typeItem) {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gererAffichageItem()");
		typeChoisi = typeItem;
    	String itemChoisi = typeItem.toString().toLowerCase();
    	List<String> items = new ArrayList<String>();
    	
    	for (int i = 1; i <= NOMBRE_CHOIX;i++){
    		items.add(itemChoisi + i +".png");
		}
    	vue.VuePimpMyHero.getInstance().AfficherListe(itemChoisi, items);
    }
    private void changerItemChoisi(Assets.ASSETS itemChoisi, int id) {
    	Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.changerItemChoisi()");
    	vue.VuePimpMyHero.getInstance().changerAsset(itemChoisi, id);
    	
    }

    
    
	public void notifierSelectionColorPicker(ColorPicker cp) {
		Logger.logMsg(Logger.INFO, "notifierSelectionColorPicker");
		VuePimpMyHero.getInstance().changerCouleurLabel(cp.getValue());
	}

	public void notifierChangementTitre(String text) {
		Logger.logMsg(Logger.INFO, "notifierChangementTitre");
		VuePimpMyHero.getInstance().changerTitre(text);
	}
}
