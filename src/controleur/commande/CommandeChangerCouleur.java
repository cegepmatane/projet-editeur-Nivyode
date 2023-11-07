package controleur.commande;

import modele.Assets;
import vue.VuePimpMyHero;

public class CommandeChangerCouleur extends Commande {
    protected String couleur;
    protected Assets.ASSETS asset;

    public CommandeChangerCouleur(String couleur) {
        super();
    }

    public void executer() {
    }

    public void annuler() {
    }

    public Object getAsset() {
        return this.asset;
    }
}
