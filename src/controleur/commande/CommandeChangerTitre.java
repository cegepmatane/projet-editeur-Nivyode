package controleur.commande;

import architecture.Vue;
import modele.Assets;
import vue.VuePimpMyHero;

public class CommandeChangerTitre extends Commande {
    protected String titre;
    protected Assets.ASSETS asset;

    public CommandeChangerTitre(String titre) {
        super();
        this.titre = titre;
        this.asset = Assets.ASSETS.LABEL;
    }

    public void executer() {
        VuePimpMyHero.getInstance().changerTitre(titre);
    }

    public void annuler() {
        CommandeChangerTitre ancienneCommande = (CommandeChangerTitre) Historique.getInstance().getCommandePrecedenteMemeType(this.asset);
        String ancienTitre = "";
        if (ancienneCommande != null) ancienTitre = ancienneCommande.getTitre();

        VuePimpMyHero.getInstance().changerTitre(ancienTitre);
        VuePimpMyHero.getInstance().ecrireTitre(ancienTitre);
    }

    public Object getAsset() {
        return this.asset;
    }

    public String getTitre() {
        return this.titre;
    }
}
