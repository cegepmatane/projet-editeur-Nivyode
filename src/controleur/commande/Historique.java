package controleur.commande;

import java.util.ArrayList;

public class Historique {
    protected ArrayList<Commande> commandes;

    public Historique() {
        commandes = new ArrayList<Commande>();
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
}
