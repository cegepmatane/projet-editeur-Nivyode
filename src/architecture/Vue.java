package architecture;

import javafx.fxml.FXMLLoader;
import com.sun.media.jfxmedia.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

@SuppressWarnings("rawtypes")
public class Vue extends Scene {
    protected static FXMLLoader parseur = null;
    protected Controleur controleur;
    protected Class classe = null;

    public Vue(String fxml, Class classe) {
        super(parser(fxml, null, classe), 1300.0D, 800.0D);
        this.classe = classe;
        this.controleur = null;
    }

    public Vue(String fxml, Class classe, double largeur, double hauteur) {
        super(parser(fxml, null, classe), largeur, hauteur);
        this.classe = classe;
        this.controleur = null;
    }

    public Vue(String fxml, Controleur controleur, Class classe) {
        super(parser(fxml, null, classe), 1300.0D, 800.0D);
        this.controleur = controleur;
    }

    public static Parent parser(String fxml, Controleur controleur, Class classe) {
        parseur = new FXMLLoader();
        parseur.setLocation(classe.getResource(fxml));
        if (controleur != null) parseur.setController(controleur);
        try {
            return parseur.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void activerControles() {
        /* 45 */
        Logger.logMsg(2, "Vue.activerControles()");
    }


    public Controleur getControleur() {
        /* 51 */
        return this.controleur;
    }
}


/* Location:              C:\Users\stamandnadine\eclipse-donnees\Ecole\lib\architecture.jar!\architecture\Vue.class
 * Java compiler version: 14 (58.0)
 * JD-Core Version:       1.1.3
 */