package controleur.commande;

import modele.Assets;
import vue.VuePimpMyHero;

public class CommandeSupprimer extends Commande {

    protected Assets.ASSETS asset;
    protected String idButton;
    protected Assets.ASSETS assetSupprimer;
    protected int idAssetSupprimer;

    public CommandeSupprimer(String idButton) {
        super();
        this.idButton = idButton;
        this.asset = Assets.ASSETS.SUPPRIMER;
    }

    public void executer() {
        String idAsset = idButton.substring(19);
        VuePimpMyHero.getInstance().supprimerAsset(idButton);
        VuePimpMyHero.getInstance().supprimerAsset(idAsset);

        String assetString = idAsset;
        if (idAsset.contains("-")) assetString = idAsset.substring(0, idAsset.indexOf("-"));
        assetSupprimer = Assets.ASSETS.valueOf(assetString.toUpperCase());
        if (!idAsset.contains("-")) {
            idAssetSupprimer = -1;
            return;
        }
        idAsset = idAsset.substring(idAsset.indexOf("-") + 1);
        idAssetSupprimer = Integer.parseInt(idAsset);
    }

    public void annuler() {
        Commande commande;
        if (this.idAssetSupprimer == -1) commande = Historique.getInstance().getCommandePrecedenteMemeType(this.assetSupprimer);
        else commande = Historique.getInstance().getCommandePrecedenteMemeTypeMemeId(this.assetSupprimer, this.idAssetSupprimer);
        if (commande != null) {
            commande.executer();
        }
    }

    public Object getAsset() {
        return this.asset;
    }

    public String getIdButton() {
        return this.idButton;
    }
}
