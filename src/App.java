import architecture.Controleur;
import architecture.Fenetre;
import vue.VuePimpMyHero;
import utilitaire.*;
import modele.Hero;
import modele.Hero.*;

public class App {
    public static void main(String[] parametres) {
        System.out.println("Hello Editeur!");
        Controleur.choisirVuePrincipale(VuePimpMyHero.class);
        Fenetre.launch(Fenetre.class, parametres);
        //Exportable hero = new Hero();
        //((Hero) hero).setCasqueActuel(CASQUE.valueOf("CASQUE1"));
        //((Hero) hero).setArmureActuelle(ARMURE.valueOf("ARMURE1"));
        //((Hero) hero).setCapeActuelle(CAPE.valueOf("CAPE1"));
        //((Hero) hero).setBackgroundActuel(BACKGROUND.valueOf("BACKGROUND1"));
        //((Hero) hero).setBottesActuelles(BOTTES.valueOf("BOTTES1"));
        //Exporteur exporteur = new Exporteur();
        //exporteur.sauvegarder(hero);
        
        
    }
}