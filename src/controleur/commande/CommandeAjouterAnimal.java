package controleur.commande;

import com.sun.media.jfxmedia.logging.Logger;
import controleur.ControleurPimpMyHero;
import modele.Animal;
import modele.Assets;
import vue.VuePimpMyHero;

public class CommandeAjouterAnimal extends Commande {
    protected Assets.ASSETS asset;
    protected int elementId;
    protected int x;
    protected int y;
    protected Animal.ANIMAL animalChoisi;
    protected ControleurPimpMyHero controleur;

    public CommandeAjouterAnimal(int x, int y, Animal.ANIMAL animalChoisi, ControleurPimpMyHero controleur) {
        super();
        this.asset = Assets.ASSETS.ANIMAL;
        this.elementId = 0;
        this.x = x;
        this.y = y;
        this.animalChoisi = animalChoisi;
        this.controleur = controleur;
    }

    public void executer() {
        Logger.logMsg(Logger.INFO, "CommandeChangerAsset.executer()");
        String id = VuePimpMyHero.getInstance().ajouterAnimal(x, y, animalChoisi);
        this.elementId = Integer.parseInt(id.substring(7));
        controleur.ajouterAnimaltoList(animalChoisi, x, y, id);
    }

    public void annuler() {
        Logger.logMsg(Logger.INFO, "CommandeAjouterAnimal.annuler()");
        VuePimpMyHero.getInstance().supprimerAsset(this.asset.toString().toLowerCase() + "-" + this.elementId);
    }

    public Assets.ASSETS getAsset() {
        return this.asset;
    }

    public int getElementId() {
        return this.elementId;
    }
}
