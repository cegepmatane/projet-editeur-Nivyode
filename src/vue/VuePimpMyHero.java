package vue;

import architecture.Vue;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import controleur.ControleurPimpMyHero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modele.Assets;

public class VuePimpMyHero extends Vue {

    protected ControleurPimpMyHero controleur;

    protected static VuePimpMyHero instance = null;
    List<String> boutons;
    ColorPicker cp;

    public static VuePimpMyHero getInstance() {
        if(null==instance)instance = new VuePimpMyHero();
        return VuePimpMyHero.instance;
    };

    private VuePimpMyHero()
    {
        super("personage.fxml", VuePimpMyHero.class, 1294,743);
        super.controleur = this.controleur = new ControleurPimpMyHero();
        Logger.logMsg(Logger.INFO, "new VuePimpMyHero()");
        
        boutons = new ArrayList<String>();
        boutons.add("#bouton-selection-casque");
        boutons.add("#bouton-selection-armure");
        boutons.add("#bouton-selection-cape");
        boutons.add("#bouton-selection-botte");
        boutons.add("#bouton-selection-animal");
        boutons.add("#bouton-selection-background");
        boutons.add("#bouton-telechargement");
        boutons.add("#bouton-refaire");
        boutons.add("#bouton-annuler");
        cp = (ColorPicker)lookup("#colorpicker");
        
    }
	public List<String> getBoutons() {
		return boutons;
	}  

    public void activerControles() {
        super.activerControles();
        
        for(String i : boutons) {
        	activerBouton(boutons.indexOf(i));
        }
        activerCP(cp);
        

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

    public void changerAsset(Assets.ASSETS asset, String elementId) {
        Logger.logMsg(Logger.INFO, "Changer " + asset.toString().toLowerCase() + ": " + elementId);
        String assetString = asset.toString().toLowerCase();

        //Récupérer l'asset s'il existe
        try {
            ImageView assetImage = (ImageView) lookup("#" + assetString);
            assetImage.setImage(new Image("vue/images/" + assetString + "/" + assetString + elementId + ".png"));
            Logger.logMsg(Logger.INFO, "L'asset a été changé");
        } catch (NullPointerException e) {
            Logger.logMsg(Logger.INFO, "L'asset n'existe pas");
            ajouterAsset(asset, elementId);
        }
    }

    public void ajouterAsset(Assets.ASSETS asset, String elementId) {
        Logger.logMsg(Logger.INFO, "Ajouter " + asset.toString().toLowerCase() + ": " + elementId);
        String assetString = asset.toString().toLowerCase();

        //Création de l'image
        ImageView assetImage = new ImageView();
        assetImage.setImage(new Image("vue/images/" + assetString + "/" + assetString + elementId + ".png"));

        //Récupérer le conteneur
        AnchorPane conteneur = (AnchorPane) lookup("#anchor-personage-pane");

        //Changer la taille de l'image
        assetImage.preserveRatioProperty().set(true);
        assetImage.setFitWidth(controleur.getAssetSize(asset));

        //Déplacer l'image
        if (controleur.getAssetPosition(asset).getX() <= 0)
            assetImage.xProperty().bind(conteneur.widthProperty().subtract(assetImage.fitWidthProperty()).divide(2));
        else
            assetImage.setX(controleur.getAssetPosition(asset).getX());
        assetImage.setY(controleur.getAssetPosition(asset).getY());

        //Assigner une id
        assetImage.setId(assetString);

        //Ajouter l'image au conteneur
        conteneur.getChildren().add(assetImage);
    }

    public void redimensionnerAsset(Assets.ASSETS asset, double width) {
    	Logger.logMsg(Logger.INFO, "Resize " + asset.toString().toLowerCase() + ": " + width);
        String assetString = asset.toString().toLowerCase();

        //Récupérer l'asset s'il existe
        try {
            ImageView assetImage = (ImageView) lookup("#" + assetString);
            assetImage.preserveRatioProperty().set(true);
            assetImage.setFitWidth(width);
            Logger.logMsg(Logger.INFO, "L'asset a été redimensionné");
        } catch (NullPointerException e) {
            Logger.logMsg(Logger.INFO, "L'asset n'existe pas");
        }
    }

    public void supprimerAsset(Assets.ASSETS asset) {
        Logger.logMsg(Logger.INFO, "Supprimer " + asset.toString().toLowerCase());
        String assetString = asset.toString().toLowerCase();

        //Récupérer l'asset s'il existe
        try {
            AnchorPane conteneur = (AnchorPane) lookup("#anchor-personage-pane");
            conteneur.getChildren().remove(lookup("#" + assetString));
            Logger.logMsg(Logger.INFO, "L'asset a été supprimé");
        } catch (NullPointerException e) {
            Logger.logMsg(Logger.INFO, "L'asset n'a pas pu être supprimé");
        }
    }
        
    private void activerBouton(int idBouton) {
        Button bouton = (Button)lookup(boutons.get(idBouton));
        bouton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Clic sur " + boutons.get(idBouton));
                controleur.notifierSelectionBouton(idBouton);}});
    }
        
        private void activerCP(ColorPicker cp) {
        	cp.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
        		@Override
        		public void handle(ActionEvent e) {
        			System.out.println("Clic sur " + cp.getId());
        			controleur.notifierSelectionColorPicker(cp);
        			System.out.println("La couleur c'est" + cp.getValue());
        		}
        	});
        }
}

