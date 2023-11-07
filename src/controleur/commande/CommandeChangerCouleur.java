package controleur.commande;

import modele.Assets;
import vue.VuePimpMyHero;

public class CommandeChangerCouleur extends Commande {
    protected String couleur;
    protected Assets.ASSETS asset;

    public CommandeChangerCouleur(String couleur) {
        super();
        this.couleur = couleur;
        this.asset = Assets.ASSETS.COULEUR;
    }

    public void executer() {
        VuePimpMyHero.getInstance().changerCouleurLabel(couleur);
    }

    public void annuler() {
        CommandeChangerCouleur ancienneCommande = (CommandeChangerCouleur) Historique.getInstance().getCommandePrecedenteMemeType(this.asset);
        String ancienneCouleur = "#333333";
        if (ancienneCommande != null) ancienneCouleur = ancienneCommande.getCouleur();
        VuePimpMyHero.getInstance().changerCouleurLabel(ancienneCouleur);
    }

    public Object getAsset() {
        return this.asset;
    }

    public String getCouleur() {
        return this.couleur;
    }
}
