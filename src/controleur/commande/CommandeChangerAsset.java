package controleur.commande;

import architecture.Vue;
import modele.Assets;
import vue.VuePimpMyHero;

public class CommandeChangerAsset extends Commande {
    protected Assets.ASSETS asset;
    protected int elementId;
    protected int ancienElementId;

    public CommandeChangerAsset(Assets.ASSETS asset, int elementId) {
        super();
        this.asset = asset;
        this.elementId = elementId;
        this.ancienElementId = elementId;
    }

    public CommandeChangerAsset(Assets.ASSETS asset, int elementId, int ancienElementId) {
        super();
        this.asset = asset;
        this.elementId = elementId;
        this.ancienElementId = ancienElementId;
    }

    public void executer() {
        VuePimpMyHero.getInstance().changerAsset(this.asset, this.elementId);
    }

    public void annuler() {
        VuePimpMyHero.getInstance().changerAsset(this.asset, this.ancienElementId);
    }
}
