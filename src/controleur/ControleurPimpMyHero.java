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
	int NOMBRE_CASQUE = 3;
	int NOMBRE_ARMURE = 3;
	int NOMBRE_CAPE = 3;
	int NOMBRE_BOTTES = 3;
	int NOMBRE_ANIMAL = 5;
	int NOMBRE_BACKGROUND = 5;
		
	

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
    		gererAffichageCasque();
    		break;
    	case 1:
    		//#bouton-selection-armure
    		gererAffichageArmure();
    		break;
    	case 2:
    		//#bouton-selection-cape
    		gererAffichageCape();
    		break;
    	case 3:
    		//#bouton-selection-bottes
    		gererAffichageBottes();
    		break;
    	case 4:
    		//#bouton-selection-animal
    		gererAffichageAnimal();
    		break;
    	case 5:
    		//#bouton-selection-background
    		gererAffichageBackground();
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
	private void gererAffichageCasque() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageCasque()");
		List<String> casques = new ArrayList<String>();
		for (int i = 1; i <= NOMBRE_CASQUE;i++){
			casques.add("casque"+ i +".png");
			System.out.println("casque.png");
		}
		vue.VuePimpMyHero.getInstance().AfficherListe("casque", casques);	
    }
	
	private void gererAffichageArmure() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageArmure()");
		List<String> armures = new ArrayList<String>();
		for (int i = 1; i <= NOMBRE_ARMURE;i++){
			armures.add("armure"+ i +".png");
		}
		vue.VuePimpMyHero.getInstance().AfficherListe("armure", armures);	
    }
	
	private void gererAffichageCape() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageCape()");
		List<String> capes = new ArrayList<String>();
		for (int i = 1; i <= NOMBRE_CAPE;i++){
			capes.add("cape"+ i +".png");
		}
		vue.VuePimpMyHero.getInstance().AfficherListe("cape", capes);	
    }
	
	private void gererAffichageBottes() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageBottes()");
		List<String> bottes = new ArrayList<String>();
		for (int i = 1; i <= NOMBRE_BOTTES;i++){
			bottes.add("bottes"+ i +".png");
		}
		vue.VuePimpMyHero.getInstance().AfficherListe("bottes", bottes);	
    }
	
	private void gererAffichageAnimal() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageAnimal()");
		List<String> animaux = new ArrayList<String>();
		for (int i = 1; i <= NOMBRE_ANIMAL;i++){
			animaux.add("animal"+ i +".png");
		}
		vue.VuePimpMyHero.getInstance().AfficherListe("animal", animaux);	
    }
	
	private void gererAffichageBackground() {
		Logger.logMsg(Logger.INFO, "ControleurPimpMyHero.gerrerAffichageBackground()");
		List<String> backgrounds = new ArrayList<String>();
		for (int i = 1; i <= NOMBRE_BACKGROUND;i++){
			backgrounds.add("background"+ i +".png");
		}
		vue.VuePimpMyHero.getInstance().AfficherListe("background", backgrounds);	
    }
	
	
	public void notifierSelectionColorPicker(ColorPicker cp) {
		Logger.logMsg(Logger.INFO, "notifierSelectionColorPicker");
	}
}
