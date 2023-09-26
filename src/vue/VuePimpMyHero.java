package vue;

import architecture.Vue;
import com.sun.media.jfxmedia.logging.Logger;
import controleur.ControleurPimpMyHero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modele.Assets;

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

    public void changerAsset(Assets.ASSETS asset, String elementId) {
        Logger.logMsg(Logger.INFO, "Changer " + asset.toString().toLowerCase() + ": " + elementId);
        String assetString = asset.toString().toLowerCase();

        //Récupérer l'asset si il existe
        try {
            ImageView assetImage = (ImageView) lookup("#" + assetString);
            assetImage.setImage(new Image("vue/images/" + assetString + "/" + assetString + "(" + elementId + ").png"));
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
        ImageView tShirt = new ImageView();
        tShirt.setImage(new Image("vue/images/" + assetString + "/" + assetString + "(" + elementId + ").png"));

        //Récupérer le conteneur
        AnchorPane conteneur = (AnchorPane) lookup("#anchor-personage-pane");

        //Changer la taille de l'image
        tShirt.preserveRatioProperty().set(true);
        tShirt.setFitWidth(100);

        //Déplacer l'image
        tShirt.xProperty().bind(conteneur.widthProperty().subtract(tShirt.fitWidthProperty()).divide(2));
        tShirt.setY(getAssetY(asset));

        //Assigner une id
        tShirt.setId(assetString);

        //Ajouter l'image au conteneur
        conteneur.getChildren().add(tShirt);
    }

    public void supprimerAsset(Assets.ASSETS asset) {
        Logger.logMsg(Logger.INFO, "Supprimer " + asset.toString().toLowerCase());
        String assetString = asset.toString().toLowerCase();

        //Récupérer l'asset si il existe
        try {
            AnchorPane conteneur = (AnchorPane) lookup("#anchor-personage-pane");
            conteneur.getChildren().remove(lookup("#" + assetString));
            Logger.logMsg(Logger.INFO, "L'asset a été supprimé");
        } catch (NullPointerException e) {
            Logger.logMsg(Logger.INFO, "L'asset n'a pas pu être supprimé");
        }
    }

    public int getAssetY(Assets.ASSETS asset) {
        return switch (asset) {
            case CHEVEUX -> 100;
            case TSHIRT -> 150;
            case PANTALON -> 200;
            case SOULIER -> 250;
            default -> 0;
        };
    }
}
