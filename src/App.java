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
        Hero hero = new Hero();
        hero.setCasqueActuel(CASQUE.valueOf("CASQUE1"));
        hero.setArmureActuelle(ARMURE.valueOf("ARMURE1"));
        hero.setCapeActuelle(CAPE.valueOf("CAPE1"));
        hero.setBackgroundActuel(BACKGROUND.valueOf("BACKGROUND1"));
        hero.setBottesActuelles(BOTTES.valueOf("BOTTES1"));
        Exporteur exporteur = new Exporteur();
        exporteur.sauvegarder(hero);
        
        
    }
}