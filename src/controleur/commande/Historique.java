package controleur.commande;

import com.sun.media.jfxmedia.logging.Logger;
import modele.Assets;

import java.util.ArrayList;

public class Historique {
    protected ArrayList<Commande> commandes;
    public static Historique instance = null;

    private Historique() {
        commandes = new ArrayList<Commande>();
        instance = this;
    }

    public static Historique getInstance() {
        if (instance == null) {
            instance = new Historique();
        }
        return instance;
    }

    public void undo() {
        if (!commandes.isEmpty()) {
            Commande commande = commandes.get(commandes.size() - 1);
            commande.annuler();
            commandes.remove(commande);
        }
    }

    public void ajouter(Commande commande) {
        commandes.add(commande);
    }

    public Commande getCommandePrecedente() {
        if (commandes.size() > 1) {
            return commandes.get(commandes.size() - 2);
        }
        return null;
    }

    public Commande getCommandePrecedenteMemeType(Assets.ASSETS type) {
        Logger.logMsg(Logger.INFO, "Historique.getCommandePrecedenteMemeType()");
        // Parcourir la liste des commandes à l'envers
        for (int i = commandes.size() - 2; i >= 0; i--) {
            Commande commande = commandes.get(i);
            // Si l'asset de la commande est du même type que l'asset de la commande courante
            if (commande.getAsset() == type) {
                return commande;
            }
        }
        return null;
    }

    public Commande getCommandePrecedenteMemeTypeMemeId(Assets.ASSETS type, int id) {
        Logger.logMsg(Logger.INFO, "Historique.getCommandePrecedenteMemeTypeMemeId()");
        // Parcourir la liste des commandes à l'envers
        for (int i = commandes.size() - 2; i >= 0; i--) {
            Commande commande = commandes.get(i);
            // Si l'asset de la commande est du même type que l'asset de la commande courante
            if (commande.getAsset() == type && commande.getElementId() == id) {
                return commande;
            }
        }
        return null;
    }
}
