package controleur.commande;

import architecture.Vue;
import com.sun.media.jfxmedia.logging.Logger;
import modele.Assets;
import vue.VuePimpMyHero;


public class CommandeChangerAsset extends Commande {
    protected Assets.ASSETS asset;
    protected int elementId;

    public CommandeChangerAsset(Assets.ASSETS asset, int elementId) {
        super();
        this.asset = asset;
        this.elementId = elementId;
    }

    public void executer() {
        Logger.logMsg(Logger.INFO, "CommandeChangerAsset.executer()");
        VuePimpMyHero.getInstance().changerAsset(this.asset, this.elementId);
    }

    public void annuler() {
        Logger.logMsg(Logger.INFO, "CommandeChangerAsset.annuler()");

        if (this.asset != Assets.ASSETS.ANIMAL) {
            Commande ancienneCommande = Historique.getInstance().getCommandePrecedenteMemeType(this.asset);
            if (this.asset == Assets.ASSETS.BACKGROUND && ancienneCommande == null) return;
            if (ancienneCommande == null) {
                VuePimpMyHero.getInstance().supprimerAsset(this.asset.toString().toLowerCase());
                return;
            }
            int ancienElementId = ((CommandeChangerAsset) ancienneCommande).getElementId();
            VuePimpMyHero.getInstance().changerAsset(this.asset, ancienElementId);
        }
    }

    public Assets.ASSETS getAsset() {
        return this.asset;
    }

    public int getElementId() {
        return this.elementId;
    }
}
