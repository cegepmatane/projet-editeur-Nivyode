import architecture.Controleur;
import architecture.Fenetre;
import vue.VuePimpMyHero;

public class App {
    public static void main(String[] parametres) {
        System.out.println("Hello Editeur!");
        Controleur.choisirVuePrincipale(VuePimpMyHero.class);
        Fenetre.launch(Fenetre.class, parametres);
    }
}